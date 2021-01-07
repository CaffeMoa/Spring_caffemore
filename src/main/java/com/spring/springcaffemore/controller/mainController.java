package com.spring.springcaffemore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mainController {

    @GetMapping("/")
    public String home(){
//        return "search";
        return "main";
    }
    @GetMapping("/main")
    public String main(){
//        return "search";
        return "main";
    }
}