package com.jejunu.portal.jmt.Service;

import com.jejunu.portal.jmt.DB.Menu;
import com.jejunu.portal.jmt.Repository.MenuRepo;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuServiceImpl {
    private final MenuRepo menuRepo;

    public MenuServiceImpl(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }

    public Menu createMenu(Menu menu) {
        return menuRepo.save(menu);
    }


}
