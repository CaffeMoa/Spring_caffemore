package com.spring.springcaffemore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class kakaoController {

    @RequestMapping(value = "/kakao/login")
    public String login(@RequestParam("code") String code) {
        System.out.println("code : " + code);
        return "redirect:/";
    }
}
