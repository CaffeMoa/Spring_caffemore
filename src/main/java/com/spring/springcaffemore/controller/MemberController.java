package com.spring.springcaffemore.controller;

import com.spring.springcaffemore.Service.MemberService;
import com.spring.springcaffemore.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.Console;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원 가입 화면
    @GetMapping("/members/new")
    public String createForm(Model model){
        //memberForm에 데이터를 넣어달라고 넘김
        model.addAttribute("memberForm",new MemberForm());
        return "members/createMemberForm";
    }

    //회원 가입 DB에 올리기
    @PostMapping(value = "/members/new")
    public String create(@Valid MemberForm form, BindingResult result,Model model) {

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());
        member.setNickname(form.getNickname());
        member.setAge(form.getAge());
        member.setPoint(0l);

        memberService.join(member);

        model.addAttribute("member",member.getEmail());
        return "redirect:/";
    }

    //로그인 버튼 누름
    @PostMapping("/members/login")
    public String login(String inputEmail, String inputPassword, HttpSession session){
        // 회원이 없다면
        Member member = memberService.findOneByEmail(inputEmail);
        if(member != null){
            String password = member.getPassword();
            if(password != null){
                if(inputPassword.equals(password)){
                    System.out.println("login success");

                    session.setAttribute("email",inputEmail);
                    session.setAttribute("nickname",member.getNickname());
                    session.setAttribute("point",member.getPoint());

                    return "redirect:/";
                }
            }
        }
        System.out.println("login fail");

        return "redirect:/";
    }

    //로그인 화면 관련
    @GetMapping("login")
    public String login(Model model){
        model.addAttribute("login","login");
        return "login";
    }

}
