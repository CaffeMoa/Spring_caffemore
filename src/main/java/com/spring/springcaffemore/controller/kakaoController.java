package com.spring.springcaffemore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class kakaoController {
    @RequestMapping(value = "/kakao_login_api")
    public String home(){
        return "main";
    }
}
