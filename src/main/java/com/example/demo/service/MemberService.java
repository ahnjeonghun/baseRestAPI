package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberDTO;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {
    @Autowired
    private MemberRepository  memberRepository;

    public List<MemberDTO> getMember(){
        List<Member> memberList = memberRepository.findAll();
        List<MemberDTO> memberDtos = memberList.stream()
                .map(MemberDTO::new)
                .collect(Collectors.toList());
        return memberDtos;
    }

    public MemberDTO getOneMember(int memberIdx){
        Member member = memberRepository.findOne(memberIdx);
        MemberDTO memberDTO = new MemberDTO(member);
        return memberDTO;
    }

    public MemberDTO create(Member newMember){
        Member member = new Member();

        member.setMemberName(newMember.getMemberName());
        member.setAddr(newMember.getAddr());
        member.setPh1(newMember.getPh1());

        memberRepository.save(member);
        MemberDTO memberDTO = new MemberDTO(member);
        return memberDTO;
    }

    public void deleteMember(int memberIdx){
        memberRepository.delete(memberIdx);
    }
}
