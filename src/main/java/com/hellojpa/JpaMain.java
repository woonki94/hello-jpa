package com.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
       EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

       EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //저장
            //Member member = new Member();
            //member.setId(2L);
            //member.setName("HelloB");
            //em.persist(member);
            /**
             * 수정
             */
            //Member findMember = em.find(Member.class, 1L);
            //findMember.setName("HelloJPA");

            //JPQL - 객체가 대상인 쿼리문..
            List<Member> result = em.createQuery("select m from Member as m", Member.class) //대부분의 쿼리 자성 가능.
                    .setFirstResult(5)  //페이징 쉽게 가능.
                    .setMaxResults(10)
                    .getResultList();


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
       emf.close();
    }
}
