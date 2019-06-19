package com.jejunu.portal.jmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String home(){
        return "맥스!";
    }
}
