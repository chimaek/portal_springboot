package com.jejunu.portal.jmt.Controller;


import com.jejunu.portal.jmt.DB.Member;
import com.jejunu.portal.jmt.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    public Member create(@RequestParam(required = false) String uid, String password ,String username) {
        return memberService.join(uid,password,username);
    }

   @GetMapping(value = "/me")
    public Member getme(@RequestHeader String auth){
        return memberService.auth(auth);
   }

}
