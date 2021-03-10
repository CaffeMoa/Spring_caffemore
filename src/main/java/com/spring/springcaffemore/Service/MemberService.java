package com.spring.springcaffemore.Service;

import com.spring.springcaffemore.domain.Member;
import com.spring.springcaffemore.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //회원 가입
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    //중복 회원 검증
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByemail(member.getEmail());
        if (!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //로그인 위함
    public List<Member> findMember(String email, String password){
        return memberRepository.findMember(email,password);
    }

    public List<Member> findByEmail(String email){
        return memberRepository.findByemail(email);
    }

    public Member findOneByEmail(String email){
        List<Member> Members = memberRepository.findByemail(email);
        return Members.get(0);
    }

    public Member findOne(Long memberIdx){
        return memberRepository.findOne(memberIdx);
    }
}

