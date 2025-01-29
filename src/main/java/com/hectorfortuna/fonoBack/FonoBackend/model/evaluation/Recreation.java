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
    private Boolean adaptsAndHasFriends;

    @Column(name = "favorite_books_and_tv_shows", length = 255)
    private String favoriteBooksAndTvShows;

    @Column(name = "observations", length = 255)
    private String observations;
}