package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PathologicalHistoryDTO {
    private Boolean physicalMalformations;
    private Boolean measles;
    private Boolean smallpox;
    private Boolean highFever;
    private Boolean fallsBlows;
    private String psychosomaticDisorders;
    private Boolean tonsilsAdenoids;
    private String operationsDone;
    private Boolean seesWell;
    private Boolean wearsGlasses;
    private String optometristReason;
    private String optometristResult;
    private Boolean hearingProblems;
    private String whichEar;
    private String howUnderstands;
    private String attendTherapy;
    private String familyDevelopmentHistory;
    private String familySurgeriesHospitalizations;
    private String observations;
}