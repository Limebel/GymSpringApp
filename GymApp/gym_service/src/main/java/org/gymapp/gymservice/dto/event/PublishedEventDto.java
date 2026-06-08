package org.gymapp.gymservice.dto.event;

import java.util.UUID;

public record PublishedEventDto(
        UUID id,
        String address
) {
}
