package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {
    @Id
    @Column(name = "member_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberIdx;
    @Column(name = "member_name")
    private String memberName;
    @Column(name = "addr")
    private String addr;
    @Column(name = "ph1")
    private String ph1;
    @Column(name = "note")
    private String note;
    @Column(name = "regiDate")
    private LocalDateTime regiDate;
/*
    public int getMemberIdx(){
        return this.memberIdx;
    }

    public void setMemberName(String memberName){
        this.memberName = memberName;
    }

    public void setAddr(String addr){
        this.addr = addr;
    }

    public void setPh1(String ph1){
        this.ph1 = ph1;
    }

    public void setNote(String note){
        this.note = note;
    }

    public void setRegiDate(LocalDate date){
        this.regiDate = date;
    }*/


}
