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


}
