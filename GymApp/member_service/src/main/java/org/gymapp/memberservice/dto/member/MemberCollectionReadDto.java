package org.gymapp.memberservice.dto.member;

import java.util.UUID;

public record MemberCollectionReadDto(
        UUID id,
        String fullName
) {
}
