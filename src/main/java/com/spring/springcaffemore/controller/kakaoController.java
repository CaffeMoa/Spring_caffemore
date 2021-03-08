package com.spring.springcaffemore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.springcaffemore.domain.Member;
import com.spring.springcaffemore.dto.KakaoProfile;
import com.spring.springcaffemore.dto.OAuth2Token;
import com.spring.springcaffemore.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpHeaders;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Console;
import java.io.IOException;


@Controller
public class kakaoController {

    private String clientId = "b84f3f30bef008822d863ad1e06c2a68";
    private String redirectUri = "http://localhost:8080/kakao/callback";

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping(value = "/kakao/login")
    public String kakaoConnect(@RequestParam String code, HttpSession session) throws IOException {
        StringBuffer loginurl = new StringBuffer();
        loginurl.append("https://kauth.kakao.com/oauth/authorize?");
        loginurl.append("client_id=" + clientId);
        loginurl.append("&redirect_uri="+redirectUri);
        loginurl.append("&response_type=code");

        return "redirect:" + loginurl.toString();
    }

    @GetMapping(value = "/kakao/callback")
    public String kakaoCallBack(String code, HttpSession session) {
        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"); //전부다 String형일 때. RestTemplate 때문에 생략가능
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();

        parameters.add("grant_type", "authorization_code");
        parameters.add("client_id", clientId);
        parameters.add("redirect_uri", redirectUri);
        parameters.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<>(parameters, headers);

        ResponseEntity response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                request,
                String.class

        );

        ObjectMapper objectMapper = new ObjectMapper();

        OAuth2Token oToken = null;
        try {
            oToken = objectMapper.readValue(response.getBody().toString(),OAuth2Token.class);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(oToken.getAccess_token());

        RestTemplate rt2 = new RestTemplate();

        HttpHeaders headers2 = new HttpHeaders();
        headers.add("Authorization", "Bearer "+oToken.getAccess_token()); //전부다 String형일 때. RestTemplate 때문에 생략가능
        headers.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"); //전부다 String형일 때. RestTemplate 때문에 생략가능

        HttpEntity request2 = new HttpEntity(headers);

        ResponseEntity response2 = rt2.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                request2,
                String.class
        );

        ObjectMapper objectMapper2 = new ObjectMapper();
        KakaoProfile kakaoProfile = null;
        try {
            kakaoProfile =
                    objectMapper2
                            .readValue(
                                    response2.getBody().toString(),
                                    KakaoProfile.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(kakaoProfile.getId());

//        // 가입자, 비가입자 확인 처리
//        Member user =
//                memberRepository
//                        .findByProviderAndProviderId("kakao", kakaoProfile.getId());
//
//        if(user == null) {
//            System.out.println("미 가입자 입니다.");
//            // 회원가입 창으로 넘어가서 email, name -> 로그인 처리
//            session.setAttribute("providerId", kakaoProfile.getId());
//            return "auth/kakaoJoin";
//        } else {
//            System.out.println("가입된 유저입니다. 로그인 처리합니다.");
//            // 로그인 처리
//            // 3. 해당 아이디로 로그인을 위해 강제 세션 부여
//            UserDetails userDetail =
//                    mMyUserDetailService.loadUserByUsername(user.getUsername());
//
//            Authentication authentication =
//                    new UsernamePasswordAuthenticationToken(userDetail, userDetail.getPassword(), userDetail.getAuthorities());
//
//            SecurityContext securityContext = SecurityContextHolder.getContext();
//            securityContext.setAuthentication(authentication);
//            session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
            return "redirect:/";

    }
}
