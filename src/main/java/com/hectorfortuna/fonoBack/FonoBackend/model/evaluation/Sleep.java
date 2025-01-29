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

    @Column(name = "observations", length = 300)
    private String observations;
}