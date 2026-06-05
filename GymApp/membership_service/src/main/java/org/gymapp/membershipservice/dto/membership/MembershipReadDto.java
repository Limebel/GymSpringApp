package org.gymapp.membershipservice.dto.membership;

import org.gymapp.membershipservice.dto.price.PriceDto;
import org.gymapp.membershipservice.entity.MembershipType;
import org.gymapp.membershipservice.entity.Price;

import java.util.UUID;

public record MembershipReadDto(
        UUID id,
        String name,
        MembershipType type,
        PriceDto monthlyPrice,
        Integer duration,
        Integer maxMembers,
        UUID gymId,
        String address
) {
}
