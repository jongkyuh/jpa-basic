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

            Book book = new Book();
            book.setAuthor("aaaa");
            book.setIsbn("bbbb");
            book.setName("바람과함께사라지다");
            book.setPrice(10000);

            em.persist(book);

            em.flush();
            em.clear();

            Item book1 = em.find(Item.class, book.getId());
            System.out.println("book1 = " + book1);


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
