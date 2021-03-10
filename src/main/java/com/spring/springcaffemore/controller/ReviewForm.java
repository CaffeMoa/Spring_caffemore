package com.spring.springcaffemore.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class ReviewForm {
    //리뷰 작성 창

    @NotEmpty(message = "리뷰를 작성해주세요!")
    private String content;

    @NotEmpty(message = "닉네임을 설정해주세요!")
    private String author;
}
