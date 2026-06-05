package org.gymapp.memberservice;

import org.gymapp.memberservice.entity.Member;
import org.gymapp.memberservice.repository.MemberRepository;
import org.gymapp.memberservice.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    void testSavedMemberRef(){
        //arrange
        Member member = Member.builder()
                .fullName("Name Surname")
                .email("email@gmail.com")
                .startDate(LocalDate.of(2026, 6, 5))
                .build();
        Member savedMember = Member.builder()
                .fullName("Name Surname")
                .email("email@gmail.com")
                .startDate(LocalDate.of(2026, 6, 5))
                .build();

        when(memberRepository.save(member)).thenReturn(savedMember);

        //act
        Member result = memberService.save(member);

        //assert
        //check if save was done
        assertEquals(savedMember, result);
        //check if save was done once
        verify(memberRepository, times(1)).save(member);
    }

    @Test
    void testReturnAllMemberRefs(){
        //arrange
        Member member1 = Member.builder()
                .fullName("Name Surname")
                .email("email@gmail.com")
                .startDate(LocalDate.of(2026, 6, 5))
                .build();
        Member member2 = Member.builder()
                .fullName("Name Surname")
                .email("email@gmail.com")
                .startDate(LocalDate.of(2026, 6, 5))
                .build();
        
        List<Member> members = List.of(member1, member2);

        when(memberRepository.findAll()).thenReturn(members);

        //act
        List<Member> results = memberService.findAll();

        //assert
        //check if returned list contain 2 elements
        assertEquals(2, results.size());
        //check if findAll was triggered once
        verify(memberRepository, times(1)).findAll();
    }

    @Test
    void testDeleteMemberRef(){
        //arrange
        Member member = Member.builder()
                .fullName("Name Surname")
                .email("email@gmail.com")
                .startDate(LocalDate.of(2026, 6, 5))
                .build();

        //act
        memberService.delete(member);

        //assert
        //check if delete was triggered once
        verify(memberRepository, times(1)).delete(member);
    }
}
