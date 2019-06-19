package com.jejunu.portal.jmt;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<Users, Long> {

    List<Users> findAllById(Iterable<Long> longs);

}
