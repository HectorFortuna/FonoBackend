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
    private Boolean understandsCommands;

    @Column(name = "emits_primitive_sounds")
    private Boolean emitsPrimitiveSounds;

    @Column(name = "language_understood_by_surroundings")
    private Boolean languageUnderstoodBySurroundings;

    @Column(name = "uses_gestures_or_mimics")
    private Boolean usesGesturesOrMimics;

    @Column(name = "sings")
    private Boolean sings;

    @Column(name = "knows_songs_from_memory")
    private Boolean knowsSongsFromMemory;

    @Column(name = "observations", length = 255)
    private String observations;
}