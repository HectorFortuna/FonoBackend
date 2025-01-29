package com.hectorfortuna.fonoBack.FonoBackend.model.patient;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.UUID;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "id_address", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "address", length = 255)
    private String address;
}