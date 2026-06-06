package org.gymapp.gymservice.controller;

import lombok.AllArgsConstructor;
import org.gymapp.gymservice.dto.gym.GymCollectionReadDto;
import org.gymapp.gymservice.dto.gym.GymCreateUpdateDto;
import org.gymapp.gymservice.dto.gym.GymReadDto;
import org.gymapp.gymservice.entity.Gym;
import org.gymapp.gymservice.mapper.GymMapper;
import org.gymapp.gymservice.service.GymService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/gyms-management/gyms")
class GymController {
    private final GymService gymService;
    private final GymMapper gymMapper;
    private final CategoryEventPublisher eventPublisher;

    @PostMapping
    public ResponseEntity<GymReadDto> createGym(
            @RequestBody GymCreateUpdateDto dto
    ) {
        Gym gym = gymMapper.toEntity(dto);
        Gym savedGym = gymService.save(gym);
        eventPublisher.categoryCreated(savedGym);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(gymMapper.toReadDto(savedGym));
    }

    @GetMapping
    public List<GymCollectionReadDto> getAllGyms() {
        return gymService.findAll()
                .stream()
                .map(gymMapper::toCollectionDto)
                .toList();
    }
}
