package com.example.demo.dto;

import com.example.demo.domain.Member;
import lombok.Getter;

@Getter
public class MemberDTO
{
    private int memberIdx;
    private  String memberName;
    private  String addr;
    private String ph1;

    public MemberDTO(Member member){
        memberIdx = member.getMemberIdx();
        memberName = member.getMemberName();
        addr = member.getAddr();
        ph1 = member.getPh1();
    }
}
