package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homecity","street","zipcode"));

            //
            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("족발");

            member.getAddressHistory().add(new AddressEntity("old1","street","zipcode"));
            member.getAddressHistory().add(new AddressEntity("old2","street","zipcode"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("===============Star==============");
            Member findMember = em.find(Member.class, member.getId());

            // homecity -> newcity
            // 값타입의 필드만 바꾸는 것이 아니라 통으로 바꿔야 한다.
//            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newcity",a.getStreet(),a.getZipzode()));

            //치킨 -> 한식 으로 변경
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");


//            findMember.getAddressHistory().remove(new AddressEntity("old1","street","zipcode"));
//            findMember.getAddressHistory().add(new AddressEntity("newCity1","street","zipcode"));


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
