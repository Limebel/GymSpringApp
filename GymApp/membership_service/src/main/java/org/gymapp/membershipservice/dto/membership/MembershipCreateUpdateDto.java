package org.gymapp.membershipservice.dto.membership;

import org.gymapp.membershipservice.dto.price.PriceDto;
import org.gymapp.membershipservice.entity.MembershipType;

import java.util.UUID;

public record MembershipCreateUpdateDto(
        String name,
        MembershipType type,
        PriceDto monthlyPrice,
        Integer duration,
        Integer maxMembers
) {
}
