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
    private Boolean physicalMalformations;

    @Column(name = "measles")
    private Boolean measles;

    @Column(name = "smallpox")
    private Boolean smallpox;

    @Column(name = "high_fever")
    private Boolean highFever;

    @Column(name = "falls_or_blows")
    private Boolean fallsBlows;

    @Column(name = "psychosomatic_disorders")
    private String psychosomaticDisorders;

    @Column(name = "tonsils_and_adenoids")
    private Boolean tonsilsAdenoids;

    @Column(name = "operations_done")
    private String operationsDone;

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

    @Column(name = "how_to_understand", length = 255)
    private String howUnderstands;

    @Column(name = "attended_therapy")
    private String attendTherapy;

    @Column(name = "family_development_history", length = 255)
    private String familyDevelopmentHistory;

    @Column(name="family_surgeries_hospitalization", length = 255)
    private String familySurgeriesHospitalizations;

    @Column(name = "observations", length = 255)
    private String observations;
}