package org.gymapp.gymservice.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "gym")
@Getter @Setter
@EqualsAndHashCode(of ="id")
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

    @NonNull
    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @NonNull
    @Column(name = "phone number", nullable = false, unique = true)
    private String phone_number;
}
