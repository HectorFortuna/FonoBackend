package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SleepDTO {
    private Boolean normal;
    private Boolean restless;
    private Boolean talksDuringSleep;
    private Boolean nocturnalEnuresis;
    private Boolean teethGrinding;
    private Boolean sleepwalking;
    private Boolean sleepsWithMouthOpen;
    private Boolean drools;
    private Boolean asBabyNoProblems;
    private Boolean asBabySleptAlone;
    private String asBabySharedWith;
    private String asBabySleepDifficulties;
    private Boolean currentNoProblems;
    private Boolean currentSleptAlone;
    private String currentSharedWith;
    private String currentSleepDifficulties;
    private String observations;
}