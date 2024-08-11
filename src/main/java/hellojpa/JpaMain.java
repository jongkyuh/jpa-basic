package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // 1. 엔티티매니저팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 2. 엔티티 매니저 생성
        EntityManager em = emf.createEntityManager();

        // 3. 트랜잭션 생성
        EntityTransaction tx = em.getTransaction();
        // 4. 트랜잭션 시작
        tx.begin();

        //code.....
        try {
            // 저장

            Team team = new Team();
            team.setName("TeamA");
            //   team.getMembers().add(member);
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            //   member.changeTeam(team);     //team의 값을 입력하지않음, 편의메소드는 한쪽에만 지정
            em.persist(member);

            team.addMember(member);
//            team.getMembers().add(member);

//            em.flush();
//            em.clear();

            Team findTeam = em.find(Team.class, team.getId());  // 1차 캐시

            System.out.println("+++++++++++++++");
            List<Member> members = findTeam.getMembers();
            System.out.println("findTeam = " + findTeam);
            System.out.println("+++++++++++++++");

            // 커밋시점에 반영
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();

        }
        // 6. 전체 어플리케이션이 종료하면 엔티티매니저팩토리 닥기
        emf.close();


    }
}
