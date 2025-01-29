package com.hectorfortuna.fonoBack.FonoBackend.model.evaluation;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "gestation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gestation {

    @Id
    @GeneratedValue
    @Column(name = "id_gestation", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "gestation_duration", nullable = false, length = 255)
    private String gestationDuration;

    @Column(name = "mother_age", length = 255)
    private String motherAge;

    @Column(name = "prenatal_treatment")
    private Boolean prenatalTreatment;

    @Column(name = "accidents")
    private Boolean accidents;

    @Column(name = "diseases_during_pregnancy")
    private Boolean diseasesDuringPregnancy;

    @Column(name = "medications_during_pregnancy")
    private Boolean medicationsDuringPregnancy;

    @Column(name = "hypotension")
    private Boolean hypotension;

    @Column(name = "hypertension")
    private Boolean hypertension;

    @Column(name = "anemia")
    private Boolean anemia;

    @Column(name = "delivery_duration", length = 255)
    private String deliveryDuration;

    @Column(name = "normal_delivery")
    private Boolean normalDelivery;

    @Column(name = "forceps_delivery", length = 255)
    private String forcepsDelivery;

    @Column(name = "cesarean_delivery")
    private Boolean cesareanDelivery;

    @Column(name = "anesthesia")
    private Boolean anesthesia;

    @Column(name = "birth_weight", length = 255)
    private String birthWeight;

    @Column(name = "cried")
    private Boolean cried;

    @Column(name = "cyanosis")
    private Boolean cyanosis;

    @Column(name = "observations", length = 300)
    private String observations;
}