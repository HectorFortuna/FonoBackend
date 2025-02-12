    package com.hectorfortuna.fonoBack.FonoBackend.service.evaluation;

    import com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation.EvaluationDTO;
    import com.hectorfortuna.fonoBack.FonoBackend.model.evaluation.Evaluation;
    import com.hectorfortuna.fonoBack.FonoBackend.model.patient.Patient;
    import com.hectorfortuna.fonoBack.FonoBackend.repository.evaluation.EvaluationRepository;
    import com.hectorfortuna.fonoBack.FonoBackend.repository.patient.PatientRepository;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    import java.util.List;
    import java.util.UUID;
    import java.util.stream.Collectors;

    @Service
    @RequiredArgsConstructor
    public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final PatientRepository patientRepository;
    private final com.hectorfortuna.fonoBack.FonoBackend.mapper.EvaluationMapper evaluationMapper;

        @Transactional(readOnly = true)
        public List<EvaluationDTO> getAllEvaluations() {
            return evaluationRepository.findAll()
                    .stream()
                    .map(evaluationMapper::convertToDTO)
                    .collect(Collectors.toList());
        }

        @Transactional(readOnly = true)
        public EvaluationDTO getEvaluationById(UUID id) {
            Evaluation evaluation = evaluationRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Evaluation not found with id: " + id));
            return evaluationMapper.convertToDTO(evaluation);
        }

        @Transactional
        public EvaluationDTO createEvaluation(EvaluationDTO evaluationDTO) {
            Patient patient = patientRepository.findById(evaluationDTO.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Patient not found with id: " + evaluationDTO.getPatientId()));

            Evaluation evaluation = evaluationMapper.convertToEntity(evaluationDTO, patient);

            evaluation = evaluationRepository.save(evaluation);

            return evaluationMapper.convertToDTO(evaluation);
        }

        @Transactional
        public EvaluationDTO updateEvaluation(UUID id, EvaluationDTO evaluationDTO) {
            Evaluation existingEvaluation = evaluationRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Evaluation not found with id: " + id));

            existingEvaluation.setMainComplaint(evaluationDTO.getMainComplaint());
            existingEvaluation.setEvaluationData(evaluationDTO.getEvaluationData());
            existingEvaluation.setGestation(evaluationMapper.convertToGestation(evaluationDTO.getGestation()));
            existingEvaluation.setNutrition(evaluationMapper.convertToNutrition(evaluationDTO.getNutrition()));
            existingEvaluation.setSleep(evaluationMapper.convertToSleep(evaluationDTO.getSleep()));
            existingEvaluation.setPsychomotorDevelopment(evaluationMapper.convertToPsychomotorDevelopment(evaluationDTO.getPsychomotorDevelopment()));
            existingEvaluation.setLanguageDevelopment(evaluationMapper.convertToLanguageDevelopment(evaluationDTO.getLanguageDevelopment()));
            existingEvaluation.setPathologicalHistory(evaluationMapper.convertToPathologicalHistory(evaluationDTO.getPathologicalHistory()));
            existingEvaluation.setIndependenceAndComprehension(evaluationMapper.convertToIndependenceAndComprehension(evaluationDTO.getIndependenceAndComprehension()));
            existingEvaluation.setHabitsAndTics(evaluationMapper.convertToHabitsAndTics(evaluationDTO.getHabitsAndTics()));
            existingEvaluation.setSchooling(evaluationMapper.convertToSchooling(evaluationDTO.getSchooling()));
            existingEvaluation.setRecreation(evaluationMapper.convertToRecreation(evaluationDTO.getRecreation()));
            existingEvaluation.setFamilyInterrelationship(evaluationMapper.convertToFamilyInterrelationship(evaluationDTO.getFamilyInterrelationship()));

            existingEvaluation = evaluationRepository.save(existingEvaluation);
            return evaluationMapper.convertToDTO(existingEvaluation);
        }

        @Transactional
        public void deleteEvaluation(UUID id) {
            Evaluation evaluation = evaluationRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Evaluation not found with id: " + id));

            evaluationRepository.delete(evaluation);
        }
    }
