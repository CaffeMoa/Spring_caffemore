package com.spring.springcaffemore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {
    @GetMapping("login")
    public String login(Model model){
        model.addAttribute("login","login");
        return "login";
    }
}
