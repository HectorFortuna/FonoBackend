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
    private String bitesNails;
    private String nailBitingHand;
    private String observations;

    @Override
    public String toString() {
        return "Usou chupeta: " + format(usedPacifier) + ". " +
                "Método de remoção da chupeta: " + format(pacifierRemovalMethod) + ". " +
                "Chupou dedo: " + formatBoolean(suckedThumb) + ". " +
                "Mão que chupava: " + format(thumbHand) + ". " +
                "Duração do hábito de chupar dedo: " + format(thumbSuckingDuration) + ". " +
                "Método de remoção do hábito: " + format(thumbSuckingRemovalMethod) + ". " +
                "Rói unhas: " + format(bitesNails) + ". " +
                "Mão que rói as unhas: " + format(nailBitingHand) + ". " +
                "Observações: " + format(observations) + ".";
    }

    private String format(String value) {
        return value != null && !value.trim().isEmpty() ? value : "Não informado";
    }

    private String formatBoolean(Boolean value) {
        return value == null ? "Não informado" : (value ? "Sim" : "Não");
    }

}