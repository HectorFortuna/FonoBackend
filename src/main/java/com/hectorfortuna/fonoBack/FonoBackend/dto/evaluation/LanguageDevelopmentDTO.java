package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageDevelopmentDTO {
    private String babbled;
    private Boolean syllableRepetition;
    private Boolean wordsWithMeaning;
    private Boolean simpleCompleteSentences;
    private String understoodByAllWhen;
    private String stutteredAround;
    private Boolean understandsCommands;
    private Boolean emitsPrimitiveSounds;
    private Boolean languageUnderstoodBySurroundings;
    private Boolean usesGesturesOrMimics;
    private Boolean sings;
    private Boolean knowsSongsFromMemory;
    private String observations;
}