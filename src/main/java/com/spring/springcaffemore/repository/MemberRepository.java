package com.spring.springcaffemore.repository;

import com.spring.springcaffemore.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

//    회원 저장
    public void save(Member member){
        em.persist(member);
    }

//    회원 찾기(단건 조회)
    public Member findOne(Long id){
        return em.find(Member.class,id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByemail(String email){
        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email",email)
                .getResultList();
    }

    public List<Member> findMember(String email, String password){
        return em.createQuery("select m from Member m where m.email = :email and m.password =: password",Member.class)
                .setParameter("email",email)
                .setParameter("password",password)
                .getResultList();
    }
}
