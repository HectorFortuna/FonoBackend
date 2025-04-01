package com.hectorfortuna.fonoBack.FonoBackend.model.patientevaluation;

import com.hectorfortuna.fonoBack.FonoBackend.model.evaluation.Evaluation;
import com.hectorfortuna.fonoBack.FonoBackend.model.patient.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "patient_evaluation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientEvaluation {

    @Id
    @GeneratedValue
    @Column(name = "id_patient_evaluation", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "id_evaluation", nullable = false)
    private Evaluation evaluation;
}
