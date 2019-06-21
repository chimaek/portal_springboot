package com.jejunu.portal.jmt.Service;

import com.jejunu.portal.jmt.DB.Menu;
import com.jejunu.portal.jmt.Repository.MemberRepo;
import com.jejunu.portal.jmt.Repository.MenuRepo;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    private MenuRepo menuRepo;

    @Autowired
    public MenuServiceImpl(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }

    @Override
    public void create(Menu menu) throws Exception {

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
