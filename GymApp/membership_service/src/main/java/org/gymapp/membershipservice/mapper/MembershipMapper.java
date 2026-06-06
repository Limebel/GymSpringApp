package org.gymapp.membershipservice.mapper;

import lombok.RequiredArgsConstructor;
import org.gymapp.membershipservice.dto.membership.MembershipCollectionReadDto;
import org.gymapp.membershipservice.dto.membership.MembershipCreateUpdateDto;
import org.gymapp.membershipservice.dto.membership.MembershipReadDto;
import org.gymapp.membershipservice.dto.price.PriceDto;
import org.gymapp.membershipservice.entity.Membership;
import org.gymapp.membershipservice.entity.Price;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MembershipMapper {
    private final PriceMapper priceMapper;

    public MembershipReadDto toReadDto(Membership membership){
        PriceDto monthlyPrice = priceMapper.toDto(membership.getMonthlyPrice());
        return new MembershipReadDto(
                membership.getId(),
                membership.getName(),
                membership.getType(),
                monthlyPrice,
                membership.getDuration(),
                membership.getMaxMembers(),
                membership.getCategory().getId(),
                membership.getCategory().getAddress()
        );
    }

    public MembershipCollectionReadDto toCollectionReadDto(Membership membership){
        return new MembershipCollectionReadDto(
                membership.getId(),
                membership.getName(),
                membership.getType()
        );
    }

    public Membership toEntity(MembershipCreateUpdateDto dto){
        Price montlyPrice = priceMapper.toEntity(dto.monthlyPrice());
        return Membership.builder()
                .name(dto.name())
                .type(dto.type())
                .price(montlyPrice)
                .duration(dto.duration())
                .maxMembers(dto.maxMembers())
                .build();
    }
}
