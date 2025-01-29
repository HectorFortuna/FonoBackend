package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NutritionDTO {
    private Boolean breastfeeding;
    private String breastfeedingDuration;
    private Boolean artificialFeeding;
    private String artificialFeedingDuration;
    private Boolean goodSuctionSwallowing;
    private Boolean choking;
    private Boolean vomiting;
    private Boolean forcedToEat;
    private String currentFeeding;
    private String observations;
}