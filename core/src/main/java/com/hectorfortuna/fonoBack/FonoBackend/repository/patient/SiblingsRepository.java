package com.hectorfortuna.fonoBack.FonoBackend.repository.patient;

import com.hectorfortuna.fonoBack.FonoBackend.model.patient.Siblings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SiblingsRepository extends JpaRepository<Siblings, UUID> {
}