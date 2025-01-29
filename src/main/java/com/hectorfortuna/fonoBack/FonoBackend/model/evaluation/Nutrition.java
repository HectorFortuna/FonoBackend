package com.hectorfortuna.fonoBack.FonoBackend.model.evaluation;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "nutrition")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nutrition {

    @Id
    @GeneratedValue
    @Column(name = "id_nutrition", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "breastfeeding")
    private Boolean breastfeeding;

    @Column(name = "breastfeeding_duration", length = 255)
    private String breastfeedingDuration;

    @Column(name = "artificial_feeding")
    private Boolean artificialFeeding;

    @Column(name = "artificial_feeding_duration", length = 255)
    private String artificialFeedingDuration;

    @Column(name = "good_suction_swallowing")
    private Boolean goodSuctionSwallowing;

    @Column(name = "choking")
    private Boolean choking;

    @Column(name = "vomiting")
    private Boolean vomiting;

    @Column(name = "forced_to_eat")
    private Boolean forcedToEat;

    @Column(name = "current_feeding", length = 255)
    private String currentFeeding;

    @Column(name = "observations", length = 300)
    private String observations;
}