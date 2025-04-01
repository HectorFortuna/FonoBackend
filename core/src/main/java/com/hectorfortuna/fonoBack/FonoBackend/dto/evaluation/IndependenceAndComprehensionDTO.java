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

    @Override
    public String toString() {
        return "Iniciou alimentação sozinho(a) com: " + format(startedEatingAloneAge) + ". " +
                "Iniciou a se vestir sozinho(a) com: " + format(startedDressingAloneAge) + ". " +
                "Começou a tomar banho sozinho(a) com: " + format(startedBathingAloneAge) + ". " +
                "Passou a identificar objetos com: " + format(startedIdentifyingObjectsAge) + ". " +
                "Observações: " + format(observations) + ".";
    }

    private String format(String value) {
        return (value != null && !value.trim().isEmpty()) ? value : "Não informado";
    }
}