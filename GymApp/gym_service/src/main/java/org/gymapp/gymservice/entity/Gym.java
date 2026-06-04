package org.gymapp.gymservice.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "gym")
@Getter @Setter
@EqualsAndHashCode(of = "address")
@ToString
public class Gym {
    @PrePersist
    public void prePersist(){
        if (id == null){
            id = UUID.randomUUID();
        }
    }

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @NotBlank
    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @NotBlank
    @Column(name = "phone number", nullable = false, unique = true)
    private String phone_number;
}
