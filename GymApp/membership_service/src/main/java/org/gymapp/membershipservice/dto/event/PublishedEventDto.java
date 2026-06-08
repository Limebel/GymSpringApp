package org.gymapp.membershipservice.dto.event;

import java.util.UUID;

public record PublishedEventDto(
        UUID id,
        String name,
        Integer maxMembers
) {
}
