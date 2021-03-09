package com.spring.springcaffemore.controller;

import com.spring.springcaffemore.Service.KakaoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class kakaoController {
    @Autowired
    private KakaoApi kakao;

    @RequestMapping(value = "/kakao/login")
    public String login(@RequestParam("code") String code, HttpSession session) {
        String access_Token = kakao.getAccessToken(code);
        HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
        System.out.println("login Controller: "+userInfo);

        //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
        if(userInfo.get("email")!=null){
            session.setAttribute("userId",userInfo.get("email"));
            session.setAttribute("nickname",userInfo.get("nickname"));
            session.setAttribute("access_Token",access_Token);
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/kakao/logout")
    public String logout(HttpSession session){
        kakao.kakaoLogout((String) session.getAttribute("access_Token"));
        session.removeAttribute("access_Token");
        session.removeAttribute("nickname");
        session.removeAttribute("userId");

        System.out.println("logout");

        return "redirect:/";
    }
}
