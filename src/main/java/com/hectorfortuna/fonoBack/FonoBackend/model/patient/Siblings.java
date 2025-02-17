package com.hectorfortuna.fonoBack.FonoBackend.model.patient;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.UUID;

@Entity
@Table(name = "siblings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Siblings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Garante que o banco gera o ID
    @Column(name = "id_siblings", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "siblings_name", nullable = false)
    private String siblingsName;

    @Column(name = "siblings_age", nullable = false, length = 255)
    private String siblingsAge;

    @ManyToOne // ⬅️ Adicionado para garantir que cada Sibling pertence a um Patient
    @JoinColumn(name = "patient_id", nullable = false) // ⬅️ Isso garante que a coluna patient_id será preenchida
    private Patient patient;
}
