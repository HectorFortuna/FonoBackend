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
    private String relationshipWithFather;

    @Column(name = "relationship_with_mother", length = 255)
    private String relationshipWithMother;

    @Column(name = "relationship_with_siblings", length = 255)
    private String relationshipWithSiblings;

    @Column(name = "relationship_with_other_relatives", length = 255)
    private String relationshipWithOtherRelatives;

    @Column(name = "observations", length = 255)
    private String observations;
}