package com.jejunu.portal.jmt.Repository;

import com.jejunu.portal.jmt.DB.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepo extends JpaRepository<Menu, Long> {

}
