package com.jejunu.portal.jmt.Service;

import com.jejunu.portal.jmt.DB.Menu;
import com.jejunu.portal.jmt.Repository.MenuRepo;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService{
    private final MenuRepo menuRepo;

    public MenuServiceImpl(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }


    @Override
    public Menu create(String menuname, String explain, Long price) {
        return null;
    }

    @Override
    public Menu delete(String menumame) {
        return null;
    }

    @Override
    public Menu read(String menuname, String explain, Long price) {
        return null;
    }

    @Override
    public Menu update(String menuname, String explain, Long price) {
        return null;
    }
}
