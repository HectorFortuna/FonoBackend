package com.hectorfortuna.fonoBack.FonoBackend.repository.evaluation;

import com.hectorfortuna.fonoBack.FonoBackend.model.evaluation.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, UUID> {
}