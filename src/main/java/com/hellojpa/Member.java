package com.hellojpa;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Entity
//@SequenceGenerator(name ="member_seq_generator", sequenceName = "member_seq")
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCE",
//        pkColumnValue = "MEMBER_SEQ", allocationSize = 50)
public class Member {
    //기본키 매핑
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) //자동생성
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // ->auto_increment(값을 코드에서 생성하지 않아야 됨)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "member_seq_generator")
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name ="USERNAME")  //db column명은 name이다.
    private String username;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();



    /**
    //@Column(name = "TEAM_ID")
    //private Long teamId;
    @ManyToOne
    @JoinColumn(name = "TEAM_ID") //foreign key를 mapping
    private  Team team; // team과 member의 연관관계를 알려줘야한다.
    **/

    /**
     private Integer age; //int == Integer

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) //
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob // database에 varchar를 넘는 contents를 쓰고 싶으면 lob사용
    private String description;

    **/

    public Member(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




        /**
         * 연관관계 편의 메서드 생성
         */
        //team.getMembers().add(this);  // this == 현재 Member객체
    //}
}
