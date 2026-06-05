package org.gymapp.gymservice.dto.event;

import java.util.UUID;

public record CategoryEventDto(
        UUID id,
        String address
) {
}
