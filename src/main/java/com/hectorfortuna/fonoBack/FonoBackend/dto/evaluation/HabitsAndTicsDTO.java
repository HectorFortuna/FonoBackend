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
    private Boolean bitesNails;
    private String nailBitingHand;
    private String observations;
}