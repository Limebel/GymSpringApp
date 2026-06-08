package org.gymapp.memberservice.mapper;

import org.gymapp.memberservice.dto.member.MemberCollectionReadDto;
import org.gymapp.memberservice.dto.member.MemberCreateDto;
import org.gymapp.memberservice.dto.member.MemberReadDto;
import org.gymapp.memberservice.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public MemberReadDto toReadDto(Member member){
        return new MemberReadDto(member.getId(),
                member.getFullName(),
                member.getEmail(),
                member.getStartDate(),
                member.getStatus(),
                member.getCategory().getId(),
                member.getCategory().getName());
    }

    public MemberCollectionReadDto toCollectionReadDto(Member member){
        return new MemberCollectionReadDto(member.getId(),
                member.getFullName());
    }

    public Member toEntity(MemberCreateDto dto){
        return Member.builder()
                .fullName(dto.fullName())
                .email(dto.email())
                .startDate(dto.startDate())
                .build();
    }
}
