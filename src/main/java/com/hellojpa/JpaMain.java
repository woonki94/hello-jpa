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

            /**
             * JPQL - 객체가 대상인 쿼리문..
             */
            
            //List<Member> result = em.createQuery("select m from Member as m", Member.class) //대부분의 쿼리 자성 가능.
             //       .setFirstResult(5)  //페이징 쉽게 가능.
              //      .setMaxResults(10)
               //     .getResultList();

            
            //비영속 
            //Member member = new Member();
            //member.setId(101L);
            //member.setName("HelloJPA3");
            
            //영속
            //System.out.println("=====Before====");
            //em.persist(member);
            //System.out.println("=====After====");


            /**
             * db쿼리가 처음에만 나가고, 두번째는 EM안의 cache에서 조회한다.
             */
            //Member findMember = em.find(Member.class, 101L);
            //Member findMember2 = em.find(Member.class, 101L);
            /**
             * result = true
             * 동일성 보장해준다..
             */
            //System.out.println("result = " +(findMember == findMember2));

            /**
             * 변경감지(dirty checking)
             */
            //Member member = em.find(Member.class, 150L);
            //member.setName("ZZZZ"); // em.persist(member) 할필요가 없다.


            /**
             *
             */
            //Member member1 = new Member(150L,"A");
            //Member member2 = new Member(160L,"B");

            //em.persist(member1);
            //em.persist(member2);
            //System.out.println("================="); //이후에 insert query가 나간다..

            //Member member = new Member();
            //member.setId("ID_A");
            //member.setUsername("C");

            //em.persist(member);

            //Team team = new Team();
            //team.setName("TeamA");
            //team.getMembers().add(member);  // member의 teamId는 null로 설정된다. member.setTeam(team)으로 해야함.
            //em.persist(team);

            //Member member = new Member();
            //member.setUsername("member1");
            //member.setTeamId(team.getId());
            /**
             * 양방향 연관관계 매핑이 됨.
             */
            //member.changeTeam(team);
            //em.persist(member);

            //team.addMember(member);   //member.changeTeam(team) or  team.addMember(member); 둘중에 하나 선택해서 작성.



            //em.flush();
            //em.clear();

            //Member findMember = em.find(Member.class, member.getId());

            //Long findTeamId = findMember.getTeamId();
            //Team findTeam = em.find(Team.class, findTeamId); //연관관계가 없어서 계속 em에 물어봐야함... 객체 지향적이지 않다.

            //List<Member> members = findMember.getTeam().getMembers();
           /// for(Member m :members){
            //    System.out.println("m.getUsername() = " + m.getUsername());
          //  }


            /**
             * 일대 다 단방향
             */
            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            Team team = new Team();
            team.setName("teamA");
            team.getMembers().add(member);

            em.persist(team);


            //commit해야 db에 반영
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
       emf.close();
    }
}
