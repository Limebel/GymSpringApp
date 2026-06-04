package org.gymapp.membershipservice;

import org.gymapp.membershipservice.entity.Membership;
import org.gymapp.membershipservice.repository.MembershipRepository;
import org.gymapp.membershipservice.service.MembershipService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class MembershipServiceTest {
    @Mock
    private MembershipRepository membershipRepository;

    @InjectMocks
    private MembershipService membershipService;

    @Test
    void testSavedMembership(){
        //arrange
        Membership membership = new Membership();
        Membership savedMembership = new Membership();

        when(membershipRepository.save(membership)).thenReturn(savedMembership);

        //act
        Membership result = membershipService.save(membership);

        //assert
        //check if save was done
        assertEquals(savedMembership, result);
        //check if save was done once
        verify(membershipRepository, times(1)).save(membership);
    }

    @Test
    void testReturnAllMemberships(){
        //arrange
        List<Membership> memberships= List.of(new Membership(), new Membership());

        when(membershipRepository.findAll()).thenReturn(memberships);

        //act
        List<Membership> results = membershipService.findAll();

        //assert
        //check if returned list contain 2 elements
        assertEquals(2, results.size());
        //check if findAll was triggered once
        verify(membershipRepository, times(1)).findAll();
    }

    @Test
    void testDeleteMembership(){
        //arrange
        Membership membership = new Membership();

        //act
        membershipService.delete(membership);

        //assert
        //check if delete was triggered once
        verify(membershipRepository, times(1)).delete(membership);
    }
}
