package com.spring.springcaffemore.controller;

import com.spring.springcaffemore.Service.KakaoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
            session.setAttribute("email",userInfo.get("email"));
            session.setAttribute("nickname",userInfo.get("nickname"));
            session.setAttribute("access_Token",access_Token);
            session.setAttribute("kakao",true);//카카오로 로그인
            session.setAttribute("point",0l);
        }

        return "redirect:/";
    }

    //로그아웃 버튼 눌림
    @RequestMapping(value = "/kakao/logout")
    public String logout(HttpSession session, HttpServletRequest req){

//        HttpSession kakao_check = req.getSession();

        //로그인을 한 상태인지 체크
        String userId = (String) session.getAttribute("email");

        //로그인을 한 상태이고
        if(userId != null)
        {
            System.out.println("userId = " + userId);

            //카카오로 로그인 한 건지 체크
            Boolean kakao_get_check = (Boolean) session.getAttribute("kakao");

            if(kakao_get_check == true) //카카오로 로그인 한 거라면
            {
                this.kakao.kakaoLogout((String) session.getAttribute("access_Token"));
                session.removeAttribute("access_Token");
                session.removeAttribute("email");
                session.removeAttribute("nickname");
                session.removeAttribute("kakao");

                System.out.println("kakao logout");

                return "redirect:/";
            }

            System.out.println("logout");

            //로그인은 했는데 카카오로 로그인 한 것이 아니라면
            session.removeAttribute("email");
            session.removeAttribute("nickname");
            session.removeAttribute("point");
            session.removeAttribute("kakao");

            return "redirect:/";
        }
        //로그인을 하지 않은 상태라면
        System.out.println("did not login");

        return "redirect:/";
    }
}
