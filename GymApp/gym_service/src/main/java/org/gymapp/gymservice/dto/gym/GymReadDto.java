package org.gymapp.gymservice.dto.gym;

import java.util.UUID;

public record GymReadDto(
        UUID id,
        String address,
        String phoneNumber
) {}
