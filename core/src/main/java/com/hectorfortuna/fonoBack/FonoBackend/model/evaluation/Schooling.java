package com.hectorfortuna.fonoBack.FonoBackend.model.evaluation;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "schooling")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Schooling {

    @Id
    @GeneratedValue
    @Column(name = "id_schooling", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "does_well_in_school")
    private Boolean doesWellInSchool;

    @Column(name = "likes_to_study")
    private Boolean likesToStudy;

    @Column(name = "parents_study_with_child")
    private Boolean parentsStudyWithChild;

    @Column(name = "arithmetic_difficulties")
    private Boolean arithmeticDifficulties;

    @Column(name = "writing_difficulties")
    private Boolean writingDifficulties;

    @Column(name = "has_been_held_back")
    private Boolean hasBeenHeldBack;

    @Column(name = "reason_for_being_held_back", length = 255)
    private String reasonForBeingHeldBack;

    @Column(name = "attended_kindergarten")
    private Boolean attendedKindergarten;

    @Column(name = "kindergarten_age", length = 255)
    private String kindergartenAge;

    @Column(name = "changed_schools_often")
    private Boolean changedSchoolsOften;

    @Column(name = "current_grade", length = 255)
    private String currentGrade;

    @Column(name = "current_school", length = 255)
    private String currentSchool;

    @Column(name = "observations", length = 255)
    private String observations;
}