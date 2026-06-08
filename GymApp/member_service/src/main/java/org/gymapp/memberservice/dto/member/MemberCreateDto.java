package org.gymapp.memberservice.dto.member;

import java.time.LocalDate;

public record MemberCreateDto(
        String fullName,
        String email,
        LocalDate startDate
) {
}
