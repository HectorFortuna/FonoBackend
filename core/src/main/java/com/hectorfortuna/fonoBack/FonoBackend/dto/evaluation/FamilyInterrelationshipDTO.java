package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FamilyInterrelationshipDTO {
    private String relationshipFather;
    private String relationshipMother;
    private String relationshipSiblings;
    private String relationshipOthers;
    private String headOrientationToAdult;
    private String smilesAtFamiliarPeople;
    private String smilesAtUnfamiliarPeople;
    private String smilesInResponse;
    private String facialExpressionVariation;
    private String emotionalExpressionContext;
    private String isAffectionate;
    private String sharesPleasure;
    private String caresAboutParents;
    private String jointAttentionPointing;
    private String commentsGesturesOrSpeech;
    private String followsPointing;
    private String respondsToPlayInvitation;
    private String initiatesWithChildren;
    private String respondsButNoInitiative;
    private String anxiousWithChildren;
    private String stereotypedPlayOnly;
    private String prefersPairPlay;
    private String anxiousWithStrangers;
    private String avoidsStrangerContact;
    private String persistentAggression;
    private String excessiveDisinhibition;
    private String contextualBehaviorVariation;
    private String worriesWhenApart;
    private String smilesAtParentsReturn;
    private String asksParentsForHelp;
    private String checksParentsInNewPlaces;
    private String schoolAdaptation;
    private String observations;

}