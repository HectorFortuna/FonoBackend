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
    private Boolean sphincterControl;
    private Boolean bumpsIntoThings;
    private Boolean dropsThingsFromHands;
    private Boolean agile;
    private Boolean orthopedicProblems;
    private Boolean usedBoots;
    private String dailyActivities;
    private String observations;
    private Boolean walksOnTiptoes;
    private Boolean swingsWhenWalking;
    private Boolean hasBalanceIssues;
    private Boolean difficultyRunningClimbing;
    private Boolean postureProblems;
    private Boolean difficultyWithObjects;
    private Boolean difficultyPlaying;
    private String motorExamples;
    private Boolean bathAlone;
    private Boolean brushesTeethAlone;
    private Boolean cleansSelf;
    private Boolean difficultyWithHygieneSequence;
    private Boolean dressesSelf;
    private Boolean buttonsClothes;
    private Boolean tiesShoes;
}