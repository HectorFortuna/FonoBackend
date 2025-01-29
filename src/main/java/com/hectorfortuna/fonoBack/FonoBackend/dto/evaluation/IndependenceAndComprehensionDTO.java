package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IndependenceAndComprehensionDTO {
    private String startedEatingAloneAge;
    private String startedDressingAloneAge;
    private String startedBathingAloneAge;
    private String startedIdentifyingObjectsAge;
    private String observations;
}