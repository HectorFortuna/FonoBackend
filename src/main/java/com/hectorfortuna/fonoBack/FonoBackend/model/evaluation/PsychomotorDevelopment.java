package com.hectorfortuna.fonoBack.FonoBackend.model.evaluation;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "psychomotor_development")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PsychomotorDevelopment {

    @Id
    @GeneratedValue
    @Column(name = "id_psychomotor_development", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "held_head_up", length = 255)
    private String heldHeadUp;

    @Column(name = "crawled")
    private Boolean crawled;

    @Column(name = "crawled_age", length = 255)
    private String crawledAge;

    @Column(name = "walked_age", length = 255)
    private String walkedAge;

    @Column(name = "floppy_or_firm_baby", length = 255)
    private String floppyOrFirmBaby;

    @Column(name = "falling_frequency", length = 255)
    private String fallingFrequency;

    @Column(name = "grabbed_objects_age", length = 255)
    private String grabbedObjectsAge;

    @Column(name = "can_jump")
    private Boolean canJump;

    @Column(name = "walking_defects", length = 255)
    private String walkingDefects;

    @Column(name = "good_direction_sense")
    private String goodDirectionSense;

    @Column(name = "anal_and_nocturnal_sphincter_control")
    private Boolean sphincterControl;

    @Column(name = "bumps_into_things")
    private Boolean bumpsIntoThings;

    @Column(name = "drops_things_from_hands")
    private Boolean dropsThingsFromHands;

    @Column(name = "agile")
    private Boolean agile;

    @Column(name = "orthopedic_problems")
    private Boolean orthopedicProblems;

    @Column(name = "used_boots")
    private Boolean usedBoots;

    @Column(name = "daily_activities", length = 255)
    private String dailyActivities;

    @Column(name = "walks_on_tiptoes")
    private Boolean walksOnTiptoes;

    @Column(name = "swings_when_walking")
    private Boolean swingsWhenWalking;

    @Column(name = "has_balance_issues")
    private Boolean hasBalanceIssues;

    @Column(name = "difficulty_running_climbing")
    private Boolean difficultyRunningClimbing;

    @Column(name = "posture_problems")
    private Boolean postureProblems;

    @Column(name = "difficulty_with_objects")
    private Boolean difficultyWithObjects;

    @Column(name = "difficulty_playing")
    private Boolean difficultyPlaying;

    @Column(name = "motor_examples", length = 255)
    private String motorExamples;

    @Column(name = "bath_alone")
    private Boolean bathAlone;

    @Column(name = "brushes_teeth_alone")
    private Boolean brushesTeethAlone;

    @Column(name = "cleans_self")
    private Boolean cleansSelf;

    @Column(name = "difficulty_with_hygiene_sequence")
    private Boolean difficultyWithHygieneSequence;

    @Column(name = "dresses_self")
    private Boolean dressesSelf;

    @Column(name = "buttons_clothes")
    private Boolean buttonsClothes;

    @Column(name = "ties_shoes")
    private Boolean tiesShoes;

    @Column(name = "observations", length = 255)
    private String observations;
}