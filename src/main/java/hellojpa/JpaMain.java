package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;


import java.time.LocalDateTime;
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
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);     // child도 persist된다.

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
          //  findParent.getChildList().remove(0);    // 0번째 인덱스 child 삭제, 실제 db에서 remove된다.

            em.remove(findParent);  // child도 같이 remove


            // 커밋시점에 반영
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();

        }
        // 6. 전체 어플리케이션이 종료하면 엔티티매니저팩토리 닥기
        emf.close();


    }



}
