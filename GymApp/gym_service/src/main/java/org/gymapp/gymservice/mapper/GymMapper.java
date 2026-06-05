package org.gymapp.gymservice.mapper;

import org.gymapp.gymservice.dto.gym.GymCollectionReadDto;
import org.gymapp.gymservice.dto.gym.GymCreateUpdateDto;
import org.gymapp.gymservice.dto.gym.GymReadDto;
import org.gymapp.gymservice.entity.Gym;
import org.springframework.stereotype.Component;

@Component
public class GymMapper {
    public GymReadDto toReadDto (Gym gym){
        return new GymReadDto(
                gym.getId(),
                gym.getAddress()
        );
    }

    public GymCollectionReadDto toCollectionDto(Gym gym) {
        return new GymCollectionReadDto(
                gym.getId(),
                gym.getAddress()
        );
    }

    public Gym toEntity(GymCreateUpdateDto dto) {
        return Gym.builder()
                .address(dto.address())
                .phoneNumber(dto.phoneNumber())
                .build();
    }
}
