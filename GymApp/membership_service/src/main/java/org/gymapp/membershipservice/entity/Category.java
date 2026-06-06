package org.gymapp.membershipservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "category")
@Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString
@AllArgsConstructor
public class Category {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @NotNull
    @Column(name = "address", nullable = false, unique = true)
    private String address;
}
