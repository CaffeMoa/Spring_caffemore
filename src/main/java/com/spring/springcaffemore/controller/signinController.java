package com.spring.springcaffemore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class signinController {

    @GetMapping("/signin")
    public String main(){
        return "signin";
    }
}
