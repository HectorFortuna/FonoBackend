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

    @Column(name = "street", length = 255)
    private String street;

    @Column(name = "number", length = 255)
    private String number;

    @Column(name = "neighborhood", length = 255)
    private String neighborhood;

    @Column(name = "city", length = 255)
    private String city;

    @Column(name = "state", length = 255)
    private String state;

    @Column(name = "cep", length = 255)
    private String cep;
}