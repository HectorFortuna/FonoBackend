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

    @Override
    public String toString() {
        return "Amamentação natural: " + formatBoolean(breastfeeding) + ". " +
                "Duração da amamentação: " + format(breastfeedingDuration) + ". " +
                "Alimentação artificial: " + formatBoolean(artificialFeeding) + ". " +
                "Duração da alimentação artificial: " + format(artificialFeedingDuration) + ". " +
                "Sucção e deglutição adequadas: " + formatBoolean(goodSuctionSwallowing) + ". " +
                "Engasgos frequentes: " + formatBoolean(choking) + ". " +
                "Vômitos frequentes: " + formatBoolean(vomiting) + ". " +
                "Era forçado a comer: " + formatBoolean(forcedToEat) + ". " +
                "Alimentação atual: " + format(currentFeeding) + ". " +
                "Observações: " + format(observations) + ".";
    }

    private String format(String value) {
        return value != null && !value.trim().isEmpty() ? value : "Não informado";
    }

    private String formatBoolean(Boolean value) {
        return value == null ? "Não informado" : (value ? "Sim" : "Não");
    }
}