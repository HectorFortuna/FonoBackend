package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecreationDTO {
    private String favoriteActivitiesAndToys;
    private Boolean adaptsHasFriends;
    private String favoriteBooksAndTvShows;
    private String observations;

    private Boolean playsWithObjects;
    private String typicalExploration;
    private String atypicalExploration;
    private Boolean functionalPlay;
    private Boolean symbolicPlayWithMiniatures;
    private Boolean symbolicPlayWithObjects;
    private Boolean symbolicPlayWithRoles;
    private String operateConsistently;
    private String pretendPlayMiniatures;
    private String pretendPlayObjects;
    private String pretendPlayRoles;
}