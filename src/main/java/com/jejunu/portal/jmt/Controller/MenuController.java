package com.jejunu.portal.jmt.Controller;

import com.jejunu.portal.jmt.DB.Menu;
import com.jejunu.portal.jmt.Repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuRepo menuRepo;

    @GetMapping("/")
    public String menuView(){
        return "menu";
    }

    @PostMapping("/add")
    public Menu add(Menu menu){
        Menu menu1 =menuRepo.save(menu);
        return menu1;
    }

    @GetMapping("/view/{id}")
    public Optional<Menu> view(@PathVariable Long id){
        Optional<Menu> menu=menuRepo.findById(id);
        return menu;
    }

    @RequestMapping("/list")
    public List<Menu> list(){
        List<Menu> menus = menuRepo.findAll();
        return menus;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        System.out.println("id는 : "+id );
        menuRepo.deleteById(id);
        return "redirect:/member/list";
    }

    @PutMapping("/edit/{id}")
    public Menu edit(Menu menu){
        Menu menu1 =menuRepo.save(menu);
        return menu1;
    }

}
