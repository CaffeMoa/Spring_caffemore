package com.spring.springcaffemore.controller;

import com.spring.springcaffemore.Service.MemberService;
import com.spring.springcaffemore.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.Console;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원 가입
    @GetMapping("/members/new")
    public String createForm(Model model){
        model.addAttribute("memberForm",new MemberForm()); //데이터를 실어서 넘김
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());
        member.setAge(form.getAge());
        member.setPoint(0l);

        memberService.join(member);
        return "redirect:/";
    }

    //로그인 버튼 누름
    @PostMapping("/members/login")
    public String login(String inputEmail,String inputPassword,Model model){
        List<Member> memberList = this.memberService.findMember(inputEmail, inputPassword);
        //로그인 성공
        if(memberList != null){
            System.out.println("login success");
            model.addAttribute("member",memberList);

            return "redirect:/";
        }
        //로그인 실패
        return "/login";
    }

}
