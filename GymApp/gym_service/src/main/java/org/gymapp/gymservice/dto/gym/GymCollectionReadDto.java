package org.gymapp.gymservice.dto.gym;

import java.util.UUID;

public record GymCollectionReadDto(
        UUID id,
        String address
) {
}
