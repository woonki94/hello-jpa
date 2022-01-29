package com.hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Team {
    @Id@GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    //@OneToMany(mappedBy = "team") //mappedBy -> member의 변수 team에 mapping이 되어있음을 알려줌  //연관관계의 주인이 member객체의 Team team
    /**
     * 일대 다 단방향
     */
    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<Member> members  =new ArrayList<>();



    public Long getId() {
        return id;
    }



    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

}
