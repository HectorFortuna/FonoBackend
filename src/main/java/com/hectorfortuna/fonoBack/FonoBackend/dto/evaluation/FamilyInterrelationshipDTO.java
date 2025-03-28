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

    @Override
    public String toString() {
        return "Relação com o pai: " + format(relationshipWithFather) + ", " +
                "mãe: " + format(relationshipWithMother) + ", " +
                "irmãos: " + format(relationshipWithSiblings) + ", " +
                "outros parentes: " + format(relationshipWithOtherRelatives) + ". " +
                "Observações: " + format(observations) + ".";
    }

    private String format(String value) {
        return value != null && !value.trim().isEmpty() ? value : "Não informado";
    }
}