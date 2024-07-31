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
        try{
            //영속
            Member member = em.find(Member.class, 150L);
            member.setName("CCCCC");

            em.detach(member);  // 준영속 상태(JPA에서 이제 관리하지 않는다.)

            System.out.println("================================");
            // 커밋시점에 반영
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();

        }
        // 6. 전체 어플리케이션이 종료하면 엔티티매니저팩토리 닥기
        emf.close();


    }
}
