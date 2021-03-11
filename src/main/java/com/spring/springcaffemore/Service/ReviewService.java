package com.spring.springcaffemore.Service;

import com.spring.springcaffemore.domain.Member;
import com.spring.springcaffemore.domain.Reviews;
import com.spring.springcaffemore.repository.MemberRepository;
import com.spring.springcaffemore.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    //리뷰 작성
    @Transactional
    public Long join(Reviews reviews){
        reviewRepository.save(reviews);
        return reviews.getId();
    }

    @Transactional
    public Long review(Long memberId, String content,String author){
        Member member = memberRepository.findOne(memberId);
        Reviews reviews = Reviews.createReview(member,content,author);

        reviewRepository.save(reviews);
        return reviews.getId();
    }

    //회원 전체 조회
    public List<Reviews> findAllReviews(){
        return reviewRepository.findAll();
    }

    //회원 아이디로 리뷰들 찾기
    public List<Reviews> findReviews(String author){
        return reviewRepository.findById(author);
    }

    //리뷰 단건 조회
    public Reviews findOne(Long reviewIdx){
        return reviewRepository.findOne(reviewIdx);
    }

}
