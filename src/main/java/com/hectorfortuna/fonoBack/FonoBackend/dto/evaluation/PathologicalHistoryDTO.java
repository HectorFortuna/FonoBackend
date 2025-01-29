package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PathologicalHistoryDTO {
    private Boolean physicalMalformationsOrDefects;
    private Boolean measles;
    private Boolean smallpox;
    private Boolean highFever;
    private Boolean fallsOrBlows;
    private Boolean psychosomaticDisorders;
    private Boolean tonsilsAndAdenoids;
    private Boolean operationsDone;
    private Boolean seesWell;
    private Boolean wearsGlasses;
    private String optometristReason;
    private String optometristResult;
    private Boolean hearingProblems;
    private String whichEar;
    private String hearingProblemTimingAndCircumstance;
    private Boolean prefersLoudSpeech;
    private Boolean frequentlyHoarse;
    private Boolean annoyedByNoise;
    private Boolean speaksVeryLoudOrVerySoft;
    private Boolean understandsWell;
    private Boolean looksAtLipsWhenListening;
    private String howToUnderstand;
    private Boolean attendedTherapy;
    private String observations;
}