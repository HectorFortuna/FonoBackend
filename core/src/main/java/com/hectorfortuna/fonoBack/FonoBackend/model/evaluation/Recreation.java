package com.hectorfortuna.fonoBack.FonoBackend.model.evaluation;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "recreation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recreation {

    @Id
    @GeneratedValue
    @Column(name = "id_recreation", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "favorite_activities_and_toys", length = 255)
    private String favoriteActivitiesAndToys;

    @Column(name = "adapts_and_has_friends")
    private Boolean adaptsHasFriends;

    @Column(name = "favorite_books_and_tv_shows", length = 255)
    private String favoriteBooksAndTvShows;

    @Column(name = "plays_with_objects")
    private Boolean playsWithObjects;

    @Column(name = "typical_exploration", length = 255)
    private String typicalExploration;

    @Column(name = "atypical_exploration", length = 255)
    private String atypicalExploration;

    @Column(name = "functional_play")
    private Boolean functionalPlay;

    @Column(name = "symbolic_play_with_miniatures")
    private Boolean symbolicPlayWithMiniatures;

    @Column(name = "symbolic_play_with_objects")
    private Boolean symbolicPlayWithObjects;

    @Column(name = "symbolic_play_with_roles")
    private Boolean symbolicPlayWithRoles;

    @Column(name = "operate_consistently", length = 255)
    private String operateConsistently;

    @Column(name = "pretend_play_miniatures", length = 255)
    private String pretendPlayMiniatures;

    @Column(name = "pretend_play_objects", length = 255)
    private String pretendPlayObjects;

    @Column(name = "pretend_play_roles", length = 255)
    private String pretendPlayRoles;

    @Column(name = "observations", length = 255)
    private String observations;
}