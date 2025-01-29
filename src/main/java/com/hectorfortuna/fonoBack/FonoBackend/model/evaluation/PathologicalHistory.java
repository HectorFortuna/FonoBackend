package com.hectorfortuna.fonoBack.FonoBackend.model.evaluation;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "pathological_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PathologicalHistory {

    @Id
    @GeneratedValue
    @Column(name = "id_pathological_history", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "physical_malformations_or_defects")
    private Boolean physicalMalformationsOrDefects;

    @Column(name = "measles")
    private Boolean measles;

    @Column(name = "smallpox")
    private Boolean smallpox;

    @Column(name = "high_fever")
    private Boolean highFever;

    @Column(name = "falls_or_blows")
    private Boolean fallsOrBlows;

    @Column(name = "psychosomatic_disorders")
    private Boolean psychosomaticDisorders;

    @Column(name = "tonsils_and_adenoids")
    private Boolean tonsilsAndAdenoids;

    @Column(name = "operations_done")
    private Boolean operationsDone;

    @Column(name = "sees_well")
    private Boolean seesWell;

    @Column(name = "wears_glasses")
    private Boolean wearsGlasses;

    @Column(name = "optometrist_reason", length = 255)
    private String optometristReason;

    @Column(name = "optometrist_result", length = 255)
    private String optometristResult;

    @Column(name = "hearing_problems")
    private Boolean hearingProblems;

    @Column(name = "which_ear", length = 255)
    private String whichEar;

    @Column(name = "hearing_problem_timing_and_circumstance", length = 255)
    private String hearingProblemTimingAndCircumstance;

    @Column(name = "prefers_loud_speech")
    private Boolean prefersLoudSpeech;

    @Column(name = "frequently_hoarse")
    private Boolean frequentlyHoarse;

    @Column(name = "annoyed_by_noise")
    private Boolean annoyedByNoise;

    @Column(name = "speaks_very_loud_or_very_soft")
    private Boolean speaksVeryLoudOrVerySoft;

    @Column(name = "understands_well")
    private Boolean understandsWell;

    @Column(name = "looks_at_lips_when_listening")
    private Boolean looksAtLipsWhenListening;

    @Column(name = "how_to_understand", length = 255)
    private String howToUnderstand;

    @Column(name = "attended_therapy")
    private Boolean attendedTherapy;

    @Column(name = "observations", length = 255)
    private String observations;
}