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

@Controller
@RequiredArgsConstructor
public class signinController {

    private final MemberService memberService;

    @GetMapping("/signin")
    public String createForm(Model model){
        model.addAttribute("memberForm",new MemberForm()); //데이터를 실어서 넘김
        return "signin";
    }

    @PostMapping(value = "/signin")
    public String create(@Valid MemberForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Member member = new Member();
        memberService.join(member);
        return "redirect:/";
    }
}
