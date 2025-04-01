package com.hectorfortuna.fonoBack.FonoBackend.model.evaluation;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "family_interrelationship")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamilyInterrelationship {

    @Id
    @GeneratedValue
    @Column(name = "id_family_interrelationship", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "relationship_with_father", length = 255)
    private String relationshipFather;

    @Column(name = "relationship_with_mother", length = 255)
    private String relationshipMother;

    @Column(name = "relationship_with_siblings", length = 255)
    private String relationshipSiblings;

    @Column(name = "relationship_with_other_relatives", length = 255)
    private String relationshipOthers;

    @Column(name = "head_orientation_to_adult", length = 255)
    private String headOrientationToAdult;

    @Column(name = "smiles_at_familiar_people", length = 255)
    private String smilesAtFamiliarPeople;

    @Column(name = "smiles_at_unfamiliar_people", length = 255)
    private String smilesAtUnfamiliarPeople;

    @Column(name = "smiles_in_response", length = 255)
    private String smilesInResponse;

    @Column(name = "facial_expression_variation", length = 255)
    private String facialExpressionVariation;

    @Column(name = "emotional_expression_context", length = 255)
    private String emotionalExpressionContext;

    @Column(name = "is_affectionate", length = 255)
    private String isAffectionate;

    @Column(name = "shares_pleasure", length = 255)
    private String sharesPleasure;

    @Column(name = "cares_about_parents", length = 255)
    private String caresAboutParents;

    @Column(name = "joint_attention_pointing", length = 255)
    private String jointAttentionPointing;

    @Column(name = "comments_gestures_or_speech", length = 255)
    private String commentsGesturesOrSpeech;

    @Column(name = "follows_pointing", length = 255)
    private String followsPointing;

    @Column(name = "responds_to_play_invitation", length = 255)
    private String respondsToPlayInvitation;

    @Column(name = "initiates_with_children", length = 255)
    private String initiatesWithChildren;

    @Column(name = "responds_but_no_initiative", length = 255)
    private String respondsButNoInitiative;

    @Column(name = "anxious_with_children", length = 255)
    private String anxiousWithChildren;

    @Column(name = "stereotyped_play_only", length = 255)
    private String stereotypedPlayOnly;

    @Column(name = "prefers_pair_play", length = 255)
    private String prefersPairPlay;

    @Column(name = "anxious_with_strangers", length = 255)
    private String anxiousWithStrangers;

    @Column(name = "avoids_stranger_contact", length = 255)
    private String avoidsStrangerContact;

    @Column(name = "persistent_aggression", length = 255)
    private String persistentAggression;

    @Column(name = "excessive_disinhibition", length = 255)
    private String excessiveDisinhibition;

    @Column(name = "contextual_behavior_variation", length = 255)
    private String contextualBehaviorVariation;

    @Column(name = "worries_when_apart", length = 255)
    private String worriesWhenApart;

    @Column(name = "smiles_at_parents_return", length = 255)
    private String smilesAtParentsReturn;

    @Column(name = "asks_parents_for_help", length = 255)
    private String asksParentsForHelp;

    @Column(name = "checks_parents_in_new_places", length = 255)
    private String checksParentsInNewPlaces;

    @Column(name = "school_adaptation", length = 255)
    private String schoolAdaptation;

    @Column(name = "observations", length = 255)
    private String observations;
}
