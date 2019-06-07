package com.jejunu.portal.cook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.ldap.PagedResultsControl;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    // 로그인화면 컨트롤러
    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    // 가입화면 컨트롤러
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    // 유저 생성
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        //기존에 있던 유저가 있는지?
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "기존에 있던 유저가 있습니다.",
                            "이미 가입한 회원이 있습니다.");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "회원가입에 성공하였습니다.");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }
    // 운영자 컨트롤러
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView =new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("username","환영합니다 " +
                user.getName() + "( "+ user.getEmail() +" )");
        modelAndView.addObject("adminMessage","Content");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

}
