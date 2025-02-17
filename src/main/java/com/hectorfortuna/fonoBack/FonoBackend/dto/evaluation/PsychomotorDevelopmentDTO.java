package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PsychomotorDevelopmentDTO {
    private String heldHeadUp;
    private Boolean crawled;
    private String crawledAge;
    private String walkedAge;
    private String floppyOrFirmBaby;
    private String fallingFrequency;
    private String grabbedObjectsAge;
    private Boolean canJump;
    private String walkingDefects;
    private String goodDirectionSense;
    private Boolean analAndNocturnalSphincterControl;
    private Boolean bumpsIntoThings;
    private Boolean dropsThingsFromHands;
    private Boolean agile;
    private Boolean orthopedicProblems;
    private Boolean usedBoots;
    private String dailyActivities;
    private String observations;
}