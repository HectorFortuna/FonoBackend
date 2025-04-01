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
    @GeneratedValue(strategy = GenerationType.AUTO) // Garante que o banco gere o ID
    @Column(name = "id_address", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "cep", nullable = false)
    private String cep;

    @ManyToOne // ⬅️ Relacionamento correto
    @JoinColumn(name = "patient_id", nullable = false) // ⬅️ Garante que cada endereço pertence a um paciente
    private Patient patient;
}
