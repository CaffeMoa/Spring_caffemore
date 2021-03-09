package com.spring.springcaffemore.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {
    //회원 가입 창

    @NotEmpty(message = "이메일은 필수입니다")
    private String email;

    @NotEmpty(message = "비밀번호는 필수입니다")
    private String password;
    private Long age;
}
