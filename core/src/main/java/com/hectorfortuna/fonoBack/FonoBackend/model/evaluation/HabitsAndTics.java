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

    @Column(name = "aligns_objects")
    private Boolean alignsObjects;

    @Column(name = "plays_with_parts_only")
    private Boolean playsWithPartsOnly;

    @Column(name = "opens_and_closes_objects")
    private Boolean opensAndClosesObjects;

    @Column(name = "reaction_when_play_interrupted", length = 255)
    private String reactionWhenPlayInterrupted;

    @Column(name = "rigid_pretend_play")
    private Boolean rigidPretendPlay;

    @Column(name = "resists_routine_change")
    private Boolean resistsRoutineChange;

    @Column(name = "fixed_activity_sequence")
    private Boolean fixedActivitySequence;

    @Column(name = "reaction_to_interruption", length = 255)
    private String reactionToInterruption;

    @Column(name = "attached_to_unusual_objects")
    private Boolean attachedToUnusualObjects;

    @Column(name = "hand_near_face")
    private Boolean handNearFace;

    @Column(name = "hands_near_body")
    private Boolean handsNearBody;

    @Column(name = "body_swing")
    private Boolean bodySwing;

    @Column(name = "arm_flapping")
    private Boolean armFlapping;

    @Column(name = "fears", length = 255)
    private String fears;

    @Column(name = "sensory_interest")
    private Boolean sensoryInterest;

    @Column(name = "sound_sensitivity")
    private Boolean soundSensitivity;

    @Column(name = "inappropriate_touch")
    private Boolean inappropriateTouch;

    @Column(name = "hyperactivity")
    private Boolean hyperactivity;


    @Column(name = "observations", length = 255)
    private String observations;
}