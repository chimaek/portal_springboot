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
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping()
    public ModelAndView list() throws Exception {
        List<Menu> list = menuService.list();
        return new ModelAndView("menu", "list", list);
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public ModelAndView writeForm() throws Exception {
        return new ModelAndView("menuWrite");
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String write(@ModelAttribute("menu") @RequestParam String menuname, Long price, String content) throws Exception {
        menuService.create(menuname, price, content);
        return "redirect://localhost:8080/menu";
    }
}
