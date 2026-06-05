package org.gymapp.gymservice.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.persistence.*;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "gym")
@Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Gym {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @NotBlank
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Builder
    public Gym(String address, String phoneNumber){
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
