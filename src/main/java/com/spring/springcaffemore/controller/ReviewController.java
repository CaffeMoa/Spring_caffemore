package com.spring.springcaffemore.controller;

import com.spring.springcaffemore.Service.ReviewService;
import com.spring.springcaffemore.domain.Reviews;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ReviewController {

    private final ReviewService reviewService;

    //리뷰 작성 화면
    @GetMapping("/reviews/new")
    public String createForm(Model model) {
        model.addAttribute("reviewForm", new ReviewForm()); //데이터를 실어서 넘김
        return "reviews/createReviewForm";
    }

    //리뷰 작성 버튼 눌림
    @PostMapping(value = "/reviews/new")
    public String create(@Valid ReviewForm form, BindingResult result){

        if(result.hasErrors()){
            return "reviews/createReviewForm";
        }

        Reviews reviews = new Reviews();
        reviewService.review(form.getContent(),form.getAuthor());//로그인한 회원 정보 넘기면 될듯

        return "redirect:/info";
    }

    //리뷰 보여주기
    @GetMapping(value = "/info")
    public String list(Model model){
        List<Reviews> reviewsList = reviewService.findAllReviews();
        model.addAttribute("reviewsList",reviewsList);
        return "info";
    }
}
