package org.gymapp.membershipservice.mapper;

import org.gymapp.membershipservice.dto.price.PriceDto;
import org.gymapp.membershipservice.entity.Price;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {
    public PriceDto toDto(Price price){
        return new PriceDto(price.getValue(), price.getCurrency());
    }

    public Price toEntity(PriceDto dto){
        return new Price(dto.value(), dto.currency());
    }
}
