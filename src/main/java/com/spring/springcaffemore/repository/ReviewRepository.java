package com.spring.springcaffemore.repository;

import com.spring.springcaffemore.domain.Member;
import com.spring.springcaffemore.domain.Reviews;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {

    private final EntityManager em;

    //리뷰 저장
    public void save(Reviews review){
        em.persist(review);
    }

    //리뷰 찾기(단건 조회)
    public Reviews findOne(Long id){
        return em.find(Reviews.class,id);
    }

    //리뷰 모두 찾기
    public List<Reviews> findAll(){
        return em.createQuery("select r from Reviews r", Reviews.class)
                .getResultList();
    }

    //회원 아이디로 게시글 찾기
    public List<Reviews> findById(String author){
        return em.createQuery("select r from Reviews r where r.author = :author", Reviews.class)
                .setParameter("author",author)
                .getResultList();
    }
}
