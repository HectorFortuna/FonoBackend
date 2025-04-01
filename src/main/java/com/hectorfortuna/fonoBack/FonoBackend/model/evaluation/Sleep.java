package com.hectorfortuna.fonoBack.FonoBackend.model.evaluation;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "sleep")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sleep {

    @Id
    @GeneratedValue
    @Column(name = "id_sleep", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "normal")
    private Boolean normal;

    @Column(name = "restless")
    private Boolean restless;

    @Column(name = "talks_during_sleep")
    private Boolean talksDuringSleep;

    @Column(name = "nocturnal_enuresis")
    private Boolean nocturnalEnuresis;

    @Column(name = "teeth_grinding")
    private Boolean teethGrinding;

    @Column(name = "sleepwalking")
    private Boolean sleepwalking;

    @Column(name = "sleeps_with_mouth_open")
    private Boolean sleepsWithMouthOpen;

    @Column(name = "drools")
    private Boolean drools;

    @Column(name = "baby_no_problem")
    private Boolean asBabyNoProblems;

    @Column(name = "baby_slept_alone")
    private Boolean asBabySleptAlone;

    @Column(name = "baby_shared_with", length = 255)
    private String asBabySharedWith;

    @Column(name = "baby_sleep_difficulties", length = 255)
    private String asBabySleepDifficulties;

    @Column(name = "current_no_problem")
    private Boolean currentNoProblems;

    @Column(name = "current_slept_alone")
    private Boolean currentSleptAlone;

    @Column(name = "current_shared_with", length = 255)
    private String currentSharedWith;

    @Column (name = "current_sleep_difficulties", length = 255)
    private String currentSleepDifficulties;

    @Column(name = "observations", length = 300)
    private String observations;
}