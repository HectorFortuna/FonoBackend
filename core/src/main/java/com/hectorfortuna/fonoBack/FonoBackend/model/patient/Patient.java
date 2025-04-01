package com.hectorfortuna.fonoBack.FonoBackend.model.patient;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
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

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true) // ⬅️ Correção
    private List<Address> addresses; // ⬅️ Corrigido para manter a consistência

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Siblings> siblings;

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

    @Column(name = "school", length = 255)
    private String school;

    @Column(name = "father_career", length = 255)
    private String fatherCareer;

    @Column(name = "mother_career", length = 255)
    private String motherCareer;

    @Column(name = "medications", length = 255)
    private String medications;

    @Column(name = "lives_with", length = 255)
    private String livesWith;

    @Column(name = "caregiver", length = 255)
    private String caregiver;
}
