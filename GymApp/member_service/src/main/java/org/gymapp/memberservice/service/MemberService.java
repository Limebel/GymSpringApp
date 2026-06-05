package org.gymapp.memberservice.service;

import lombok.AllArgsConstructor;
import org.gymapp.memberservice.entity.Member;
import org.gymapp.memberservice.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member save(Member member){
        //TODO: Add max member check
        return memberRepository.save(member);
    }

    public List<Member> findAll() {return memberRepository.findAll(); }

    public void delete(Member member) { memberRepository.delete(member); }
}
