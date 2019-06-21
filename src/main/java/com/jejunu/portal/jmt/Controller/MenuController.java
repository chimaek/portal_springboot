package com.jejunu.portal.jmt.Controller;

import com.jejunu.portal.jmt.DB.Menu;
import com.jejunu.portal.jmt.Repository.MenuRepo;
import com.jejunu.portal.jmt.Service.MemberService;
import com.jejunu.portal.jmt.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuRepo menuRepo;
    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping()
    public ModelAndView list() throws Exception {
        List<Menu> list = menuService.list();
        return new ModelAndView("menu", "list", list);
    }

    @GetMapping("/post/{id}")
    public ModelAndView getbno(@PathVariable Long id) throws Exception {
        Menu menu = menuService.read(id);
        return new ModelAndView("menuWrite") {{
            addObject("menu", menu);
            addObject("bno", id);
        }};
    }
    @PostMapping("/post/{id}")
    public String updatebno(@PathVariable Long id, @RequestParam String menuname, @RequestParam Long price, @RequestParam String content) throws Exception {
        Menu menu = menuRepo.findById(id).orElseThrow(Exception::new);
        menu.setMenuname(menuname);
        menu.setContent(content);
        menu.setPrice(price);
        System.out.println("뭐");
        menuRepo.save(menu);
        return "redirect:/menu";
    }
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public ModelAndView writeForm() throws Exception {
        return new ModelAndView("menuWrite");
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String write(@ModelAttribute("menu") @RequestParam String menuname, Long price, String content) throws Exception {
//        menuService.create(menuname, price, content);
        menuRepo.save(Menu.builder().menuname(menuname).content(content).price(price).build());
        return "redirect://localhost:8080/menu";
    }

    @RequestMapping(value = "/{bno}",method = RequestMethod.GET)
    public ModelAndView view(@PathVariable("bno") Long bno)throws Exception{
        Menu menu = menuService.read(bno);
        return new ModelAndView("menuView","menu",menu);
    }

    @RequestMapping(value = "/post/{bno}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("bno")Long bno)throws Exception{
        menuService.delete(bno);
        return "redirect:/menu";
    }
}
