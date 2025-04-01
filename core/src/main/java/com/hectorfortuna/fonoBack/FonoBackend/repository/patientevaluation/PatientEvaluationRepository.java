package com.hectorfortuna.fonoBack.FonoBackend.repository.patientevaluation;

import com.hectorfortuna.fonoBack.FonoBackend.model.patientevaluation.PatientEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientEvaluationRepository extends JpaRepository<PatientEvaluation, UUID> {
}