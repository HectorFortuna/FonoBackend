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
    private Boolean forcedEat;

    @Column(name = "current_feeding", length = 255)
    private String currentFeeding;

    @Column(name = "weaning", length = 255)
    private String weaning;

    @Column(name = "bottle_feeding_age", length = 255)
    private String bottleFeedingAge;

    @Column(name ="solid_food_introduction_age", length = 255)
    private String solidFoodIntroductionAge;

    @Column(name ="accepts_different_textures")
    private Boolean acceptsDifferentTextures;

    @Column(name = "feeding_issues_description", length = 255)
    private String feedingIssuesDescription;

    @Column(name = "food_selectivity", length = 255)
    private String foodSelectivity;

    @Column(name = "observations", length = 300)
    private String observations;
}