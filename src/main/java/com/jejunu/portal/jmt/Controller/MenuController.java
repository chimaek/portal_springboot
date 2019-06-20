package com.jejunu.portal.jmt.Controller;

import com.jejunu.portal.jmt.DB.Menu;
import com.jejunu.portal.jmt.Repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuRepo menuRepo;

    @RequestMapping("/add")
    public Menu add(Menu menu){
        Menu menu1 =menuRepo.save(menu);
        return menu1;
    }

    @RequestMapping("/view/{id}")
    public Optional<Menu> view(@PathVariable Long id){
        Optional<Menu> menu=menuRepo.findById(id);
        return menu;
    }

    @RequestMapping("/list")
    public List<Menu> list(){
        List<Menu> menus = menuRepo.findAll();
        return menus;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        System.out.println("id는 : "+id );
        menuRepo.deleteById(id);
        return "redirect:/member/list";
    }

    @RequestMapping("/edit/{id}")
    public Menu edit(Menu menu){
        Menu menu1 =menuRepo.save(menu);
        return menu1;
    }

}
