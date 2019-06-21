package com.jejunu.portal.jmt.Controller;


import com.jejunu.portal.jmt.DB.Member;
import com.jejunu.portal.jmt.Service.MemberService;
import com.jejunu.portal.jmt.exception.authorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //생성
    @PostMapping("/create")
    public Member create(@RequestParam String uid, String password, String username) throws Exception {
        return memberService.join(uid, password, username);
    }
    //리스트
    @GetMapping(value = "/list")
    public List<Member> list(){
        List<Member> memberList = memberService.MEMBER_LIST();
        return memberList;
    }

    //본인의 정보 반환
    @GetMapping(value = "/me")
    public Member GetMe(@RequestHeader String Author) throws authorizedException {
        return memberService.auth(Author);
    }


}
