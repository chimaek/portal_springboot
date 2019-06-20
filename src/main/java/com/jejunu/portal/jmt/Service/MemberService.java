package com.jejunu.portal.jmt.Service;

import com.jejunu.portal.jmt.DB.Member;

public interface MemberService {
    Member join(String username, String uid, String password);
    Member auth(String token);
}
