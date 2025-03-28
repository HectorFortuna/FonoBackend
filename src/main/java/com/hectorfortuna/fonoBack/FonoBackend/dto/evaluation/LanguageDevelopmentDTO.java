package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageDevelopmentDTO {
    private String babbled;
    private String syllableRepetition;
    private String wordsWithMeaning;
    private String simpleCompleteSentences;
    private String understoodByAllWhen;
    private String stutteredAround;
    private Boolean understandsCommands;
    private Boolean emitsPrimitiveSounds;
    private Boolean languageUnderstoodBySurroundings;
    private Boolean usesGesturesOrMimics;
    private Boolean sings;
    private Boolean knowsSongsFromMemory;
    private String observations;

    @Override
    public String toString() {
        return "Balbuciou com: " + format(babbled) + ". " +
                "Repetiu sílabas com: " + format(syllableRepetition) + ". " +
                "Disse palavras com significado com: " + format(wordsWithMeaning) + ". " +
                "Formou frases simples/completas com: " + format(simpleCompleteSentences) + ". " +
                "Foi compreendido por todos a partir de: " + format(understoodByAllWhen) + ". " +
                "Gaguejou por volta de: " + format(stutteredAround) + ". " +
                "Compreende comandos: " + formatBoolean(understandsCommands) + ". " +
                "Emite sons primitivos: " + formatBoolean(emitsPrimitiveSounds) + ". " +
                "Sua linguagem é compreendida pelas pessoas ao redor: " + formatBoolean(languageUnderstoodBySurroundings) + ". " +
                "Usa gestos ou mímicas: " + formatBoolean(usesGesturesOrMimics) + ". " +
                "Canta: " + formatBoolean(sings) + ". " +
                "Sabe músicas de cor: " + formatBoolean(knowsSongsFromMemory) + ". " +
                "Observações: " + format(observations) + ".";
    }

    private String format(String value) {
        return value != null && !value.trim().isEmpty() ? value : "Não informado";
    }

    private String formatBoolean(Boolean value) {
        return value == null ? "Não informado" : (value ? "Sim" : "Não");
    }
}