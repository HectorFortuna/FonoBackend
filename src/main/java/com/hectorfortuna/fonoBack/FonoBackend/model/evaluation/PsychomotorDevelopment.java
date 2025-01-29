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

    @Column(name = "walking_defects", length = 255)
    private String walkingDefects;

    @Column(name = "good_direction_sense")
    private Boolean goodDirectionSense;

    @Column(name = "anal_and_nocturnal_sphincter_control")
    private Boolean analAndNocturnalSphincterControl;

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

    @Column(name = "observations", length = 255)
    private String observations;
}