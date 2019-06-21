package com.jejunu.portal.jmt.Service;

import com.jejunu.portal.jmt.DB.Menu;

public interface MenuService {

    Menu create(String menuname, String explain, Long price);

    Menu delete(String menumame);

    Menu read(String menuname, String explain, Long price);

    Menu update(String menuname,String explain, Long price);

}
