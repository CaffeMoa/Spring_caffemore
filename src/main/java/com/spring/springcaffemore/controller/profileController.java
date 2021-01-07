package com.spring.springcaffemore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class profileController {

    @GetMapping("/profile")
    public String modifyInfo(Model model){
        model.addAttribute("profile","profile");
        return "profile";
    }
}