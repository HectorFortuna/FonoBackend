package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecreationDTO {
    private String favoriteActivitiesAndToys;
    private Boolean adaptsAndHasFriends;
    private String favoriteBooksAndTvShows;
    private String observations;
}