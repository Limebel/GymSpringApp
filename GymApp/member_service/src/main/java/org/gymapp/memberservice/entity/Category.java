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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Builder
    public Category(String name){
        this.name = name;
    }
}
