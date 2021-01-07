package com.spring.springcaffemore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class modifyInfoController {

    @GetMapping("/modifyInfo")
    public String modifyInfo(Model model){
        model.addAttribute("modifyInfo","modifyInfo");
        return "modifyInfo";
    }
}