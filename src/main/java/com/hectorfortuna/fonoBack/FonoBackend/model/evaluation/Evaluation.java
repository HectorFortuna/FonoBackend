package com.hectorfortuna.fonoBack.FonoBackend.model.evaluation;

import com.hectorfortuna.fonoBack.FonoBackend.model.patientevaluation.PatientEvaluation;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "evaluation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evaluation {

    @Id
    @GeneratedValue
    @Column(name = "id_evaluation", nullable = false, updatable = false)
    private UUID id;

    @OneToOne(mappedBy = "evaluation", cascade = CascadeType.ALL, orphanRemoval = true)
    private PatientEvaluation patientEvaluation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gestation_id", nullable = false)
    private Gestation gestation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nutrition_id", nullable = false)
    private Nutrition nutrition;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sleep_id", nullable = false)
    private Sleep sleep;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "psychomotor_development_id", nullable = false)
    private PsychomotorDevelopment psychomotorDevelopment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "language_development_id", nullable = false)
    private LanguageDevelopment languageDevelopment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pathological_history_id", nullable = false)
    private PathologicalHistory pathologicalHistory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "independence_and_comprehension_id", nullable = false)
    private IndependenceAndComprehension independenceAndComprehension;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "habits_and_tics_id", nullable = false)
    private HabitsAndTics habitsAndTics;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schooling_id", nullable = false)
    private Schooling schooling;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recreation_id", nullable = false)
    private Recreation recreation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "family_interrelationship_id", nullable = false)
    private FamilyInterrelationship familyInterrelationship;

    @Column(name = "main_complaint", length = 255)
    private String mainComplaint;

    @Column(name = "evaluation_data", length = 255)
    private String evaluationData;
}