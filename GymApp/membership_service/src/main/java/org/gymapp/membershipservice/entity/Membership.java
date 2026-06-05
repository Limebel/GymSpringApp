package org.gymapp.membershipservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "membership")
@Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Membership {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
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
    @Column(name = "duration_months", nullable = false)
    private Integer duration;

    @NotNull
    @Column(name = "max_members", nullable = false)
    private Integer maxMembers;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "category", nullable = false)
    private Category category;

    @Builder
    public Membership(String name, MembershipType type, Price price, Integer duration,
                      Integer maxMembers, Category category){
        this.name = name;
        this.type = type;
        this.monthlyPrice = price;
        this.duration = duration;
        this.maxMembers = maxMembers;
        this.category = category;
    }
}