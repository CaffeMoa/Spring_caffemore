package com.spring.springcaffemore.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter @Setter
//리뷰
public class Reviews {

    @Id @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    private String author; //리뷰 작성자
    private String content;
    private LocalDateTime reviewDate; //리뷰 작성일자

    public static Reviews createReview(String content, String author){
        Reviews review = new Reviews();
        review.setContent(content);
        review.setAuthor(author);
        review.setReviewDate(LocalDateTime.now());

        return review;
    }
}
