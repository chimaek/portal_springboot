package com.jejunu.portal.jmt.Service;

import com.jejunu.portal.jmt.Repository.MenuRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class MenuService {
    private MenuRepo menuRepo;

}
