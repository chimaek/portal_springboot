package com.jejunu.portal.jmt.Service;

import com.jejunu.portal.jmt.DB.Menu;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface MenuService {

    public Menu create(String menuname, Long price, String content) throws Exception;

    public Menu read(Long bno) throws Exception;


    public void update(Menu menu) throws Exception;

    public void delete(Long bno) throws Exception;

    public List<Menu> list() throws Exception;

}
