package org.gymapp.membershipservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "membership")
@Getter @Setter
@EqualsAndHashCode(of = {"name", "type"})
@ToString
public class Membership {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @NotBlank
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotNull
    @Enumerated
    @Column(name = "type", nullable = false)
    private MembershipType type;

    @Embedded
    private Price monthlyPrice;

    @NotNull
    @Column(name = "duration months", nullable = false)
    private Integer duration;

    @NotNull
    @Column(name = "max members", nullable = false)
    private Integer maxMembers;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryRef category;
}