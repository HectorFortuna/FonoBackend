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
    private Boolean understandCommands;
    private Boolean emitsPrimitiveSounds;
    private Boolean languageUnderstood;
    private Boolean usesGesture;
    private Boolean sings;
    private Boolean knowsSongs;
    private String observations;
    private String firstVocalizationsAge;
    private String firstWords;
    private String firstSentences;
    private String speechDelay;
    private Boolean gestureHelp;
    private Boolean gestureShare;
    private Boolean gestureNodYes;
    private Boolean gestureNodNo;
    private Boolean gestureWave;
    private Boolean gestureBlowKiss;
    private Boolean gestureImitate;
    private Boolean gestureClap;
    private Boolean gestureLiftArms;
    private Boolean gestureShakeFingerNo;
    private Boolean looksWhenPointed;
    private Boolean usesAdultHand;
    private Boolean answersToName;
    private String speechArticulation;
    private String speechRhythm;
    private Boolean echolalia;
    private Boolean repeatsPhrases;
    private Boolean pronounConfusion;
    private Boolean inventsWords;
    private Boolean strangeWordCombinations;
    private Boolean insistsOnRepetition;
    private String reactionWhenContradicted;
}