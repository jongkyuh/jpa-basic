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
           Member member = new Member(200L,"member200");
           em.persist(member);

           em.flush();  // 이 시점에 즉시 DB에 쿼리문이 나가서 반영된다.

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
