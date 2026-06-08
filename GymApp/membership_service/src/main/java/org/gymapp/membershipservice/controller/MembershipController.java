package org.gymapp.membershipservice.controller;

import lombok.RequiredArgsConstructor;
import org.gymapp.membershipservice.dto.membership.MembershipCollectionReadDto;
import org.gymapp.membershipservice.dto.membership.MembershipCreateUpdateDto;
import org.gymapp.membershipservice.dto.membership.MembershipReadDto;
import org.gymapp.membershipservice.entity.Category;
import org.gymapp.membershipservice.entity.Membership;
import org.gymapp.membershipservice.exceptions.NotFoundException;
import org.gymapp.membershipservice.mapper.MembershipMapper;
import org.gymapp.membershipservice.service.CategoryService;
import org.gymapp.membershipservice.service.MembershipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/memberships-management")
@RequiredArgsConstructor
public class MembershipController {
    private final MembershipService membershipService;
    private final CategoryService categoryService;
    private final MembershipMapper membershipMapper;
    private final EventPublisher eventPublisher;

    @PostMapping("/gyms/{gymId}/memberships")
    public ResponseEntity<MembershipReadDto> createMembership(
            @PathVariable UUID gymId,
            @RequestBody MembershipCreateUpdateDto dto
    ){
        Category category = categoryService.findById(gymId)
                .orElseThrow(() -> new NotFoundException("Gym not known in membership service"));

        Membership membership = membershipMapper.toEntity(dto);
        membership.setCategory(category);
        Membership savedMembership = membershipService.save(membership);
        eventPublisher.membershipCreated(savedMembership);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(membershipMapper.toReadDto(savedMembership));
    }

    @GetMapping("/memberships")
    public List<MembershipCollectionReadDto> getAllMemberships() {
        return membershipService.findAll()
                .stream()
                .map(membershipMapper::toCollectionReadDto)
                .toList();
    }

    @GetMapping("/memberships/{membershipId}")
    public ResponseEntity<MembershipReadDto> getMembershipById(
            @PathVariable UUID membershipId
    ) {
        return membershipService.findById(membershipId)
                .map(membershipMapper::toReadDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Membership not found"));
    }
}
