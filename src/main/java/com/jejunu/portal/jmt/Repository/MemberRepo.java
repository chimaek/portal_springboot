package com.jejunu.portal.jmt.Repository;

import com.jejunu.portal.jmt.DB.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {
    Member findByUidAndPassword(String uid, String password);
}
