package org.gymapp.memberservice;

import org.gymapp.memberservice.entity.Category;
import org.gymapp.memberservice.entity.Member;
import org.gymapp.memberservice.exceptions.MembershipFullException;
import org.gymapp.memberservice.repository.MemberRepository;
import org.gymapp.memberservice.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    void testSavedMember(){
        //arrange
        Category category = new Category(UUID.randomUUID(), "Membership1", 10);
        Member member = Member.builder()
                .fullName("Name Surname")
                .email("email@gmail.com")
                .startDate(LocalDate.of(2026, 6, 5))
                .category(category)
                .build();
        Member savedMember = Member.builder()
                .fullName("Name Surname")
                .email("email@gmail.com")
                .startDate(LocalDate.of(2026, 6, 5))
                .category(category)
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
    void testSavedMemberForOccupiedMembership(){
        //arrange
        Category category = new Category(UUID.randomUUID(), "Membership1", 1);
        category.setMembersSigned(1);
        Member member = Member.builder()
                .fullName("Name Surname")
                .email("email@gmail.com")
                .startDate(LocalDate.of(2026, 6, 5))
                .category(category)
                .build();

        //act and assert
        //check if exception occurred
        assertThrows(MembershipFullException.class, () -> {
            memberService.save(member);
        });
    }

    @Test
    void testFindAllMembers(){
        //arrange
        Category category = new Category(UUID.randomUUID(), "Membership1", 10);
        Member member1 = Member.builder()
                .fullName("Name Surname")
                .email("email@gmail.com")
                .startDate(LocalDate.of(2026, 6, 5))
                .category(category)
                .build();
        Member member2 = Member.builder()
                .fullName("Name Surname")
                .email("email@gmail.com")
                .startDate(LocalDate.of(2026, 6, 5))
                .category(category)
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
    void testFindExistingMember() {
        // arrange
        UUID id = UUID.randomUUID();
        Category category = new Category(id, "Membership2", 10);
        Member member = Member.builder()
                .fullName("Name Surname")
                .email("email@gmail.com")
                .startDate(LocalDate.of(2026, 6, 5))
                .category(category)
                .build();
        member.setId(id);

        when(memberRepository.findById(id))
                .thenReturn(Optional.of(member));

        // act
        Optional<Member> result = memberService.findById(id);

        // assert
        //check if value was returned with the same id
        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
        //check if findById was triggered once
        verify(memberRepository, times(1)).findById(id);
    }

    @Test
    void testFindNonExistingMember() {
        // arrange
        UUID id = UUID.randomUUID();

        when(memberRepository.findById(id))
                .thenReturn(Optional.empty());

        // act
        Optional<Member> result = memberService.findById(id);

        // assert
        //check if returned value is empty
        assertTrue(result.isEmpty());
        //check if findById was triggered once
        verify(memberRepository, times(1)).findById(id);
    }

    @Test
    void testDeleteMember(){
        //arrange
        Category category = new Category(UUID.randomUUID(), "Membership1", 10);
        Member member = Member.builder()
                .fullName("Name Surname")
                .email("email@gmail.com")
                .startDate(LocalDate.of(2026, 6, 5))
                .category(category)
                .build();

        //act
        memberService.delete(member);

        //assert
        //check if delete was triggered once
        verify(memberRepository, times(1)).delete(member);
    }

    @Test
    void testDeleteExistingMemberById(){
        //arrange
        UUID id = UUID.randomUUID();
        Category category = new Category(UUID.randomUUID(), "Membership1", 10);
        Member member = Member.builder()
                .fullName("Name Surname")
                .email("email@gmail.com")
                .startDate(LocalDate.of(2026, 6, 5))
                .category(category)
                .build();
        member.setId(id);

        when(memberRepository.findById(id)).thenReturn(Optional.of(member));

        //act
        boolean result = memberService.deleteById(id);

        //assert
        //check if return value is true
        assertTrue(result);
        //check if delete was triggered once
        verify(memberRepository, times(1)).delete(member);
    }

    @Test
    void testDeleteNonExistingMemberById(){
        //arrange
        UUID id = UUID.randomUUID();

        when(memberRepository.findById(id)).thenReturn(Optional.empty());

        //act
        boolean result = memberService.deleteById(id);

        //assert
        //check if return value is false
        assertFalse(result);
        //check if delete was not triggered
        verify(memberRepository, never()).delete(any());
    }
}
