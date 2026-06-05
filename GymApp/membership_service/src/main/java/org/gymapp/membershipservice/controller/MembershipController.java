package org.gymapp.membershipservice.controller;

import lombok.RequiredArgsConstructor;
import org.gymapp.membershipservice.service.CategoryService;
import org.gymapp.membershipservice.service.MembershipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
class MembershipController {
    private final MembershipService personService;
    private final CategoryService categoryService;
}
