package com.hectorfortuna.fonoBack.FonoBackend.model.patient;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.UUID;

@Entity
@Table(name = "siblings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Siblings {

    @Id
    @GeneratedValue
    @Column(name = "id_siblings", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "siblings_age", nullable = false, length = 255)
    private String siblingsAge;
}