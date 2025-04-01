package com.hectorfortuna.fonoBack.FonoBackend.model.evaluation;

import jakarta.persistence.*;
import lombok.*;

import java.awt.datatransfer.StringSelection;
import java.util.UUID;

@Entity
@Table(name = "language_development")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageDevelopment {

    @Id
    @GeneratedValue
    @Column(name = "id_language_development", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "babbled", length = 255)
    private String babbled;

    @Column(name = "syllable_repetition")
    private String syllableRepetition;

    @Column(name = "words_with_meaning")
    private String wordsWithMeaning;

    @Column(name = "simple_complete_sentences")
    private String simpleCompleteSentences;

    @Column(name = "understood_by_all_when", length = 255)
    private String understoodByAllWhen;

    @Column(name = "stuttered_around", length = 255)
    private String stutteredAround;

    @Column(name = "understands_commands")
    private Boolean understandCommands;

    @Column(name = "emits_primitive_sounds")
    private Boolean emitsPrimitiveSounds;

    @Column(name = "language_understood_by_surroundings")
    private Boolean languageUnderstood;

    @Column(name = "uses_gestures_or_mimics")
    private Boolean usesGesture;

    @Column(name = "sings")
    private Boolean sings;

    @Column(name = "knows_songs_from_memory")
    private Boolean knowsSongs;

    @Column(name = "first_vocalizations_age", length = 255)
    private String firstVocalizationsAge;

    @Column(name = "first_words", length = 255)
    private String firstWords;

    @Column(name = "first_sentences", length = 255)
    private String firstSentences;

    @Column(name = "speech_delay", length = 255)
    private String speechDelay;

    @Column(name = "gesture_help")
    private Boolean gestureHelp;

    @Column(name = "gesture_share")
    private Boolean gestureShare;

    @Column(name = "gesture_nod_yes")
    private Boolean gestureNodYes;

    @Column(name = "gesture_nod_no")
    private Boolean gestureNodNo;

    @Column(name = "gesture_wave")
    private Boolean gestureWave;

    @Column(name = "gesture_blow_kiss")
    private Boolean gestureBlowKiss;

    @Column(name = "gesture_imitate")
    private Boolean gestureImitate;

    @Column(name = "gesture_clap")
    private Boolean gestureClap;

    @Column(name = "gesture_lift_arms")
    private Boolean gestureLiftArms;

    @Column(name = "gesture_shake_finger_no")
    private Boolean gestureShakeFingerNo;

    @Column(name = "looks_when_pointed")
    private Boolean looksWhenPointed;

    @Column(name = "uses_adult_hand")
    private Boolean usesAdultHand;

    @Column(name = "answers_to_name")
    private Boolean answersToName;

    @Column(name = "speech_articulation", length = 255)
    private String speechArticulation;

    @Column(name = "speech_rhythm", length = 255)
    private String speechRhythm;

    @Column(name = "echolalia")
    private Boolean echolalia;

    @Column(name = "repeats_phrases")
    private Boolean repeatsPhrases;

    @Column(name = "pronoun_confusion")
    private Boolean pronounConfusion;

    @Column(name = "invents_words")
    private Boolean inventsWords;

    @Column(name = "strange_word_combinations")
    private Boolean strangeWordCombinations;

    @Column(name = "insists_on_repetition")
    private Boolean insistsOnRepetition;

    @Column(name = "reaction_when_contradicted", length = 255)
    private String reactionWhenContradicted;

    @Column(name = "observations", length = 255)
    private String observations;
}