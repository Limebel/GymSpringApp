package org.gymapp.membershipservice.dto.membership;

import org.gymapp.membershipservice.entity.MembershipType;

import java.util.UUID;

public record MembershipCollectionReadDto(
        UUID id,
        String name,
        MembershipType type
) {
}
