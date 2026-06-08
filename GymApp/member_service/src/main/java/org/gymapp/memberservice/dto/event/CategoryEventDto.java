package org.gymapp.memberservice.dto.event;

import java.util.UUID;

public record CategoryEventDto(
        UUID id,
        String name,
        Integer maxMembers
) {
}
