package org.gymapp.memberservice.entity;

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
public class Category {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "members_signed", nullable = false)
    private Integer membersSigned;

    @NotNull
    @Column(name = "max_members", nullable = false)
    private Integer maxMembers;

    @Builder
    public Category(UUID id, String name, Integer maxMembers){
        this.id = id;
        this.name = name;
        this.membersSigned = 0;
        this.maxMembers = maxMembers;
    }
}
