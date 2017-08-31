package com.example.demo.controller;


import com.example.demo.domain.Member;
import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {

        return new ModelAndView("redirect:http://www.naver.com");
    }
    @GetMapping("/members")
    public ResponseEntity get() {
        List<MemberDTO> memberDtos = memberService.getMember();

        return new ResponseEntity(memberDtos, HttpStatus.OK);
    }

    @GetMapping("/member/{memberIdx}")
    public ResponseEntity get_one(@PathVariable int memberIdx) {
        MemberDTO memberDto = memberService.getOneMember(memberIdx);

        return new ResponseEntity(memberDto, HttpStatus.OK);
    }

    @PostMapping("/members")
    public ResponseEntity create(@Valid Member newMember) {
        MemberDTO memberDto = memberService.create(newMember);
        return new ResponseEntity(memberDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/member/{memberIdx}")
    public ResponseEntity delete(@PathVariable int memberIdx) {
        memberService.deleteMember(memberIdx);
        return new ResponseEntity(null, HttpStatus.OK);
    }


}

