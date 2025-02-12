package com.hectorfortuna.fonoBack.FonoBackend.model.patient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hectorfortuna.fonoBack.FonoBackend.model.patientevaluation.PatientEvaluation;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.*;

@Entity
@Table(name = "patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_patient", nullable = false, updatable = false)
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "patient_id") // Nome da coluna que vai associar os endereços com o paciente
    private List<Address> address; // Agora é uma lista de endereços

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "patient_id") // Nome da coluna que vai associar os irmãos com o paciente
    private List<Siblings> siblings;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PatientEvaluation> evaluations = new ArrayList<>();

    @Column(name = "patient_name", nullable = false, length = 255)
    private String patientName;

    @Column(name = "father_name", length = 255)
    private String fatherName;

    @Column(name = "mother_name", length = 255)
    private String motherName;

    @Column(name = "birth_date", nullable = false, length = 255)
    private String birthDate;

    @Column(name = "patient_age", nullable = false, length = 255)
    private String patientAge;

    @Column(name = "phone_number", nullable = false, length = 255)
    private String phoneNumber;

    @Column(name = "career", length = 255)
    private String career;
}
