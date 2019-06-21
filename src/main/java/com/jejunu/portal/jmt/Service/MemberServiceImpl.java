package com.jejunu.portal.jmt.Service;

import com.jejunu.portal.jmt.DB.Member;
import com.jejunu.portal.jmt.Repository.MemberRepo;
import com.jejunu.portal.jmt.exception.AlreadyExistsException;
import com.jejunu.portal.jmt.exception.authorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepo memberRepo;

    @Autowired
    public MemberServiceImpl(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    @Override
    public Member join(String uid, String username, String password) {
        Member member = memberRepo.findByUid(uid);
        if (member != null) {
            throw new AlreadyExistsException("Duplicate username");
        }
        return memberRepo.save(Member.builder().uid(uid).username(username).password(password).build());
    }

    @Override
    public Member auth(String token) throws authorizedException {
        try {
            String[] split = token.split(" ");
            String type = split[0];
            String credential = split[1];

            if ("Basic".equalsIgnoreCase(type)) {
                String decoded = new String(Base64Utils.decodeFromString(credential));
                String[] usernameAndPassword = decoded.split(":");

                Member member = memberRepo.findByUidAndPassword(usernameAndPassword[0], usernameAndPassword[1]);
                if (member == null) {
                    throw new authorizedException("Invalid credentials");
                } else {
                    return member;
                }
            } else {
                throw new authorizedException("Unsupported type: " + type);
            }
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
            throw new authorizedException("Invalid credentials");
        }
    }

    @Override
    public List<Member> MEMBER_LIST() {
        return memberRepo.findAll();
    }

    @Override
    public boolean exists(String token) {
        try {
            Member member = auth(token);
            if (member != null) return true;
        } catch (authorizedException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public Member findByid(Long id) {
        return memberRepo.findById(id).get();
    }
}
