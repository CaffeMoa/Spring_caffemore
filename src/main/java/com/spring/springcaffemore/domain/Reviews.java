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

    private String author; //리뷰 작성자 (익명)
    private String content;
    private LocalDateTime reviewDate; //리뷰 작성일자

    //리뷰 작성 회원 id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void setMember(Member member){
        this.member = member;
        member.getReviews().add(this);
    }

    public static Reviews createReview(Member member, String content, String author){
        Reviews review = new Reviews();
        review.setMember(member);
        review.setContent(content);
        review.setAuthor(author);
        review.setReviewDate(LocalDateTime.now());

        return review;
    }
}
