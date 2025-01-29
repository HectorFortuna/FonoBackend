package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FamilyInterrelationshipDTO {
    private String relationshipWithFather;
    private String relationshipWithMother;
    private String relationshipWithSiblings;
    private String relationshipWithOtherRelatives;
    private String observations;
}