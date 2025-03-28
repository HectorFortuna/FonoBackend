package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GestationDTO {
    private String gestationDuration;
    private String motherAge;
    private Boolean prenatalTreatment;
    private String accidents;
    private String diseasesDuringPregnancy;
    private String medicationsDuringPregnancy;
    private Boolean hypotension;
    private Boolean hypertension;
    private Boolean anemia;
    private String deliveryDuration;
    private Boolean normalDelivery;
    private String forcepsDelivery;
    private Boolean cesareanDelivery;
    private Boolean anesthesia;
    private String birthWeight;
    private String birthHeight;
    private Boolean cried;
    private Boolean cyanosis;
    private String observations;

    private String pregnancyExperience;
    private String coupleRelationship;
    private String maternalHealthConditions;
    private String postpartumExperience;
    private String motherBabyHealthPostpartum;
    private String postpartumDepression;
    private String firstDaysAtHome;
}