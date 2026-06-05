package org.gymapp.membershipservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Price {
    @NotNull
    @Positive
    @Digits(integer = 8, fraction = 2)
    @Column(name="price_value", precision=10, scale=2, nullable = false)
    private BigDecimal value;

    @NotBlank
    @Column(name="currency", nullable = false)
    private String currency;

    @Builder
    public Price(BigDecimal value, String currency){
        this.value = value;
        this.currency = currency;
    }
}
