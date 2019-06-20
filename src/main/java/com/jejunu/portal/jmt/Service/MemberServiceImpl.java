package com.jejunu.portal.jmt.Service;

import com.jejunu.portal.jmt.DB.Member;
import com.jejunu.portal.jmt.Repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepo memberRepo;

    @Autowired
    public MemberServiceImpl(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    @Override
    public Member join(String username, String uid, String password) {
        return memberRepo.save(new Member(username,uid, password));
    }

    @Override
    public Member auth(String token) {
        String[] split = token.split(" ");
        String type = split[0];
        String credential = split[1];

        Member member = null;
        if ("Basic".equalsIgnoreCase(type)) {
            String decoded = new String(Base64Utils.decodeFromString(credential));
            String[] uidAndPassword = decoded.split(":");
            member = memberRepo.findByUidAndPassword(uidAndPassword[0], uidAndPassword[1]);
        }
        return member;
    }
}
