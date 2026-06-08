package org.gymapp.memberservice.service;

import lombok.AllArgsConstructor;
import org.gymapp.memberservice.entity.Member;
import org.gymapp.memberservice.exceptions.MembershipFullException;
import org.gymapp.memberservice.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member save(Member member){
        if(member.getCategory().getMaxMembers()<= member.getCategory().getMembersSigned()) {
            throw new MembershipFullException("No free places available in membership for new member");
        }
        member.getCategory().setMembersSigned(member.getCategory().getMembersSigned()+1);
        return memberRepository.save(member);
    }

    public List<Member> findAll() {return memberRepository.findAll(); }

    public Optional<Member> findById(UUID id) {return memberRepository.findById(id); }

    public void delete(Member member) { memberRepository.delete(member); }

    public boolean deleteById(UUID id){
        Optional<Member> personOpt = findById(id);

        if (personOpt.isPresent()) {
            delete(personOpt.get());
            return true;
        }
        return false;
    }
}
