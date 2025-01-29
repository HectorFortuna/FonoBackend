package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GestationDTO {
    private String gestationDuration;
    private String motherAge;
    private Boolean prenatalTreatment;
    private Boolean accidents;
    private Boolean diseasesDuringPregnancy;
    private Boolean medicationsDuringPregnancy;
    private Boolean hypotension;
    private Boolean hypertension;
    private Boolean anemia;
    private String deliveryDuration;
    private Boolean normalDelivery;
    private String forcepsDelivery;
    private Boolean cesareanDelivery;
    private Boolean anesthesia;
    private String birthWeight;
    private Boolean cried;
    private Boolean cyanosis;
    private String observations;
}