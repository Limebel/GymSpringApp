package org.gymapp.membershipservice;

import org.gymapp.membershipservice.entity.Category;
import org.gymapp.membershipservice.entity.Membership;
import org.gymapp.membershipservice.entity.MembershipType;
import org.gymapp.membershipservice.entity.Price;
import org.gymapp.membershipservice.repository.MembershipRepository;
import org.gymapp.membershipservice.service.MembershipService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
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
        Price price = new Price(new BigDecimal("400"), "PLN");
        Category category = new Category("street");
        Membership membership = Membership.builder()
                .name("name")
                .type(MembershipType.BASIC)
                .price(price)
                .duration(6)
                .maxMembers(10)
                .category(category)
                .build();
        Membership savedMembership = Membership.builder()
                .name("name")
                .type(MembershipType.BASIC)
                .price(price)
                .duration(6)
                .maxMembers(10)
                .category(category)
                .build();

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
        Price price = new Price(new BigDecimal("400"), "PLN");
        Category category = new Category("street");
        Membership membership1 = Membership.builder()
                .name("name")
                .type(MembershipType.BASIC)
                .price(price)
                .duration(6)
                .maxMembers(10)
                .category(category)
                .build();
        Membership membership2 = Membership.builder()
                .name("name")
                .type(MembershipType.BASIC)
                .price(price)
                .duration(6)
                .maxMembers(10)
                .category(category)
                .build();
        List<Membership> memberships= List.of(membership1, membership2);

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
        Price price = new Price(new BigDecimal("400"), "PLN");
        Category category = new Category("street");
        Membership membership = Membership.builder()
                .name("name")
                .type(MembershipType.BASIC)
                .price(price)
                .duration(6)
                .maxMembers(10)
                .category(category)
                .build();

        //act
        membershipService.delete(membership);

        //assert
        //check if delete was triggered once
        verify(membershipRepository, times(1)).delete(membership);
    }
}
