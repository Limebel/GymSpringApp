package org.gymapp.memberservice.controller;

import lombok.AllArgsConstructor;
import org.gymapp.memberservice.dto.member.MemberCollectionReadDto;
import org.gymapp.memberservice.dto.member.MemberCreateDto;
import org.gymapp.memberservice.dto.member.MemberReadDto;
import org.gymapp.memberservice.entity.Category;
import org.gymapp.memberservice.entity.Member;
import org.gymapp.memberservice.exceptions.MembershipFullException;
import org.gymapp.memberservice.exceptions.NotFoundException;
import org.gymapp.memberservice.mapper.MemberMapper;
import org.gymapp.memberservice.service.CategoryService;
import org.gymapp.memberservice.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/members-management")
@AllArgsConstructor
public class MemberController {
    MemberService memberService;
    CategoryService categoryService;
    MemberMapper memberMapper;

    @PostMapping("/memberships/{membershipId}/members")
    public ResponseEntity<MemberReadDto> createMember(
            @PathVariable UUID membershipId,
            @RequestBody MemberCreateDto dto
    ){
        Category category = categoryService.findById(membershipId)
                .orElseThrow(() -> new NotFoundException("Membership not known in member service"));

        Member member = memberMapper.toEntity(dto);
        member.setCategory(category);
        Member savedMember = memberService.save(member);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memberMapper.toReadDto(savedMember));
    }

    @GetMapping("/members")
    public List<MemberCollectionReadDto> getAllMembers() {
        return memberService.findAll()
                .stream()
                .map(memberMapper::toCollectionReadDto)
                .toList();
    }

    @DeleteMapping("/members/{memberId}")
    public ResponseEntity<Void> deletePerson(
            @PathVariable UUID memberId
    ) {
        boolean deleted = memberService.deleteById(memberId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            throw new NotFoundException("Person not found with id: " + memberId);
        }
    }
}
