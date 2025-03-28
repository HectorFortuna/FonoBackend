package com.hectorfortuna.fonoBack.FonoBackend.model.evaluation;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "habits_and_tics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitsAndTics {

    @Id
    @GeneratedValue
    @Column(name = "id_habits_and_tics", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "used_pacifier", length = 255)
    private String usedPacifier;

    @Column(name = "pacifier_removal_method", length = 255)
    private String pacifierRemovalMethod;

    @Column(name = "sucked_thumb")
    private Boolean suckedThumb;

    @Column(name = "thumb_hand", length = 255)
    private String thumbHand;

    @Column(name = "thumb_sucking_duration", length = 255)
    private String thumbSuckingDuration;

    @Column(name = "thumb_sucking_removal_method", length = 255)
    private String thumbSuckingRemovalMethod;

    @Column(name = "bites_nails")
    private String bitesNails;

    @Column(name = "nail_biting_hand", length = 255)
    private String nailBitingHand;

    @Column(name = "observations", length = 255)
    private String observations;
}