package org.gymapp.memberservice.dto.member;

import org.gymapp.memberservice.entity.MemberStatus;

import java.time.LocalDate;
import java.util.UUID;

public record MemberReadDto(
        UUID id,
        String fullName,
        String email,
        LocalDate startDate,
        MemberStatus status,
        UUID membershipId,
        String membershipName
) {
}
