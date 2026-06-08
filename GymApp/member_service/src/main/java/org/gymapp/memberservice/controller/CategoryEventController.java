package org.gymapp.memberservice.controller;

import lombok.RequiredArgsConstructor;
import org.gymapp.memberservice.dto.event.CategoryEventDto;
import org.gymapp.memberservice.entity.Category;
import org.gymapp.memberservice.service.CategoryService;
import org.gymapp.memberservice.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/events/memberships")
@RequiredArgsConstructor
public class CategoryEventController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Void> onCategoryCreated(
            @RequestBody CategoryEventDto dto
    ) {
        Category category = new Category(dto.id(), dto.name(), dto.maxMembers());
        categoryService.save(category);
        return ResponseEntity.noContent().build();
    }
}
