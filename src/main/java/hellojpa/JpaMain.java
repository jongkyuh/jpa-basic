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
            Member member1 = new Member();
            Member member2 = new Member();
            Member member3 = new Member();
         //   member.setId("ID_A");
            member1.setUsername("A");
            member2.setUsername("A");
            member3.setUsername("A");

            System.out.println("============================================");

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);


            System.out.println("============================================");
            System.out.println("member = " + member1.getId());
            System.out.println("커밋");
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
