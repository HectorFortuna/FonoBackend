package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SchoolingDTO {
    private Boolean doesWellInSchool;
    private Boolean likesToStudy;
    private Boolean parentsStudyWithChild;
    private Boolean arithmeticDifficulties;
    private Boolean writingDifficulties;
    private Boolean hasBeenHeldBack;
    private String reasonForBeingHeldBack;
    private Boolean attendedKindergarten;
    private String kindergartenAge;
    private Boolean changedSchoolsOften;
    private String currentGrade;
    private String currentSchool;
    private String observations;
}