package com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class EvaluationDTO {
    private UUID id;
    private UUID patientId;
    private GestationDTO gestation;
    private NutritionDTO nutrition;
    private SleepDTO sleep;
    private PsychomotorDevelopmentDTO psychomotorDevelopment;
    private LanguageDevelopmentDTO languageDevelopment;
    private PathologicalHistoryDTO pathologicalHistory;
    private IndependenceAndComprehensionDTO independenceAndComprehension;
    private HabitsAndTicsDTO habitsAndTics;
    private SchoolingDTO schooling;
    private RecreationDTO recreation;
    private FamilyInterrelationshipDTO familyInterrelationship;
    private String mainComplaint;
    private String evaluationData;
}