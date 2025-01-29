package com.hectorfortuna.fonoBack.FonoBackend.model.evaluation;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "independence_and_comprehension")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IndependenceAndComprehension {

    @Id
    @GeneratedValue
    @Column(name = "id_independence_and_comprehension", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "started_eating_alone_age", length = 255)
    private String startedEatingAloneAge;

    @Column(name = "started_dressing_alone_age", length = 255)
    private String startedDressingAloneAge;

    @Column(name = "started_bathing_alone_age", length = 255)
    private String startedBathingAloneAge;

    @Column(name = "started_identifying_objects_age", length = 255)
    private String startedIdentifyingObjectsAge;

    @Column(name = "observations", length = 255)
    private String observations;
}