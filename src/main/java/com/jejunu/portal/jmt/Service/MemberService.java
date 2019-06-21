package com.jejunu.portal.jmt.Service;

import com.jejunu.portal.jmt.DB.Member;
import com.jejunu.portal.jmt.exception.authorizedException;

import java.util.List;

public interface MemberService {
    //가입 하는 부분
    Member join(String username, String uid, String password) throws Exception;
    // 인증
    Member auth(String token) throws authorizedException;
    // 리스트 가져오기
    List<Member> MEMBER_LIST();

    //존재?
    boolean exists(String token);

    //특정 사용자 검색
    Member findByid(Long id);
}
