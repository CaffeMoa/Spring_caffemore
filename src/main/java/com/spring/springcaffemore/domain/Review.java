package com.spring.springcaffemore.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
//리뷰 작성 엔티티
public class Review {

    @Id @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    // 리뷰 작성 회원
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    //
}
