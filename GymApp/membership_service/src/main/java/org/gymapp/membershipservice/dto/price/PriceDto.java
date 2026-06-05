package org.gymapp.membershipservice.dto.price;

import java.math.BigDecimal;

public record PriceDto(
        BigDecimal value,
        String currency
) {
}
