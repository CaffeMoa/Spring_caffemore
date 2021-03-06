package com.spring.springcaffemore.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

@Entity
@Getter @Setter
public class Member {
//    고객고유번호, 이메일, 나이, 비밀번호, 리뷰 리스트(나중에)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_idx")
    private Long memberIdx;

    private String email;
    private String password;
    private Long age;

    private Long point;

//    @OneToMany(mappedBy = "member")
//    private List<Review> reviewList = new ArrayList<>();
}
