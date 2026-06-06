package org.gymapp.membershipservice.controller;

import lombok.RequiredArgsConstructor;
import org.gymapp.membershipservice.dto.event.CategoryEventDto;
import org.gymapp.membershipservice.entity.Category;
import org.gymapp.membershipservice.service.CategoryService;
import org.gymapp.membershipservice.service.MembershipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/events/gyms")
@RequiredArgsConstructor
class CategoryEventController {
    private final CategoryService categoryService;
    private final MembershipService membershipService;

    @PostMapping
    public ResponseEntity<Void> onCategoryCreated(
            @RequestBody CategoryEventDto dto
    ) {
        Category category = new Category(dto.id(), dto.address());
        categoryService.save(category);
        return ResponseEntity.noContent().build();
    }
}
