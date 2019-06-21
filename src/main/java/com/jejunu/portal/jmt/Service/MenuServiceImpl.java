package com.jejunu.portal.jmt.Service;

import com.jejunu.portal.jmt.DB.Menu;
import com.jejunu.portal.jmt.Repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private MenuRepo menuRepo;

    @Autowired
    public MenuServiceImpl(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }

    @Override
    public Menu create(String menuname,Long price,String content) throws Exception {
        Menu menu1 = new Menu(menuname,price,content);
        return menuRepo.save(menu1);
    }

    @Override
    public Menu read(Long bno) throws Exception {

        return null;
    }

    @Override
    public void update(Menu menu) throws Exception {

    }

    @Override
    public void delete(Long bno) throws Exception {

    }

    @Override
    public List<Menu> list() throws Exception {
        return menuRepo.findAll();
    }

    @Override
    public void increaseViewcnt(Long bno, HttpSession httpSession) throws Exception {

    }
}
