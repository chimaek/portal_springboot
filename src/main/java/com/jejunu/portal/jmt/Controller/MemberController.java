package com.jejunu.portal.jmt.Controller;


import com.jejunu.portal.jmt.Member;
import com.jejunu.portal.jmt.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MemberController {
    private MemberRepo memberRepo;

    @Autowired
    public MemberController(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    //생성
    @PostMapping
    public Member create(@RequestParam String uid) {
        return memberRepo.save(new Member(uid));
    }

    //모든 사용자 검색
    @GetMapping
    public Iterable<Member> list() {
        return memberRepo.findAll();
    }

    @GetMapping(value = "/{uid}")
    public Optional<Member> findOne(@PathVariable Long uid) {
        return memberRepo.findById(uid);
    }

}
