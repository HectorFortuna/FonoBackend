package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HabitsAndTicsDTO {
    private String usedPacifier;
    private String pacifierRemovalMethod;
    private Boolean suckedThumb;
    private String thumbHand;
    private String thumbSuckingDuration;
    private String thumbSuckingRemovalMethod;
    private String bitesNails;
    private String nailBitingHand;
    private Boolean alignsObjects;
    private Boolean playsWithPartsOnly;
    private Boolean opensAndClosesObjects;
    private String reactionWhenPlayInterrupted;
    private Boolean rigidPretendPlay;
    private Boolean resistsRoutineChange;
    private Boolean fixedActivitySequence;
    private String reactionToInterruption;
    private Boolean attachedToUnusualObjects;
    private Boolean handNearFace;
    private Boolean handsNearBody;
    private Boolean bodySwing;
    private Boolean armFlapping;
    private String fears;
    private Boolean sensoryInterest;
    private Boolean soundSensitivity;
    private Boolean inappropriateTouch;
    private Boolean hyperactivity;
    private String observations;

}