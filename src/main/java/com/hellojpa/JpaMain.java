package com.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
       EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

       EntityManager em = emf.createEntityManager();

       Member member = new Member();
       member.setId(1L);
       member.setName("HelloA");
       em.persist(member);


       em.close();
       emf.close();
    }
}
