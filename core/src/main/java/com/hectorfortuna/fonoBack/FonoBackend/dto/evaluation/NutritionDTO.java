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
    private Boolean forcedEat;
    private String currentFeeding;
    private String weaning;
    private String bottleFeedingAge;
    private String solidFoodIntroductionAge;
    private Boolean acceptsDifferentTextures;
    private String feedingIssuesDescription;
    private String foodSelectivity;
    private String observations;

}