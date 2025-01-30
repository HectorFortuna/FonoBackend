package com.hectorfortuna.fonoBack.FonoBackend.service.evaluation;

import com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation.EvaluationDTO;
import com.hectorfortuna.fonoBack.FonoBackend.mapper.EvaluationMapper;
import com.hectorfortuna.fonoBack.FonoBackend.model.evaluation.*;
import com.hectorfortuna.fonoBack.FonoBackend.model.patient.Patient;
import com.hectorfortuna.fonoBack.FonoBackend.model.patientevaluation.PatientEvaluation;
import com.hectorfortuna.fonoBack.FonoBackend.repository.evaluation.EvaluationRepository;
import com.hectorfortuna.fonoBack.FonoBackend.repository.patient.PatientRepository;
import com.hectorfortuna.fonoBack.FonoBackend.repository.patientevaluation.PatientEvaluationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EvaluationServiceTest {

    @Mock
    private EvaluationRepository evaluationRepository;

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientEvaluationRepository patientEvaluationRepository;

    @Mock
    private EvaluationMapper evaluationMapper;

    @InjectMocks
    private EvaluationService evaluationService;

    private UUID evaluationId;
    private UUID patientId;
    private Evaluation evaluation;
    private EvaluationDTO evaluationDTO;
    private Patient patient;
    private PatientEvaluation patientEvaluation;

    @BeforeEach
    void setUp() {
        evaluationId = UUID.randomUUID();
        patientId = UUID.randomUUID();

        // Criando um paciente fictício
        patient = new Patient();
        patient.setId(patientId);
        patient.setPatientName("João da Silva");

        // Criando uma avaliação fictícia com todas as associações
        evaluation = Evaluation.builder()
                .id(evaluationId)
                .gestation(new Gestation())
                .nutrition(new Nutrition())
                .sleep(new Sleep())
                .psychomotorDevelopment(new PsychomotorDevelopment())
                .languageDevelopment(new LanguageDevelopment())
                .pathologicalHistory(new PathologicalHistory())
                .independenceAndComprehension(new IndependenceAndComprehension())
                .habitsAndTics(new HabitsAndTics())
                .schooling(new Schooling())
                .recreation(new Recreation())
                .familyInterrelationship(new FamilyInterrelationship())
                .mainComplaint("Speech delay")
                .evaluationData("Some evaluation data")
                .build();

        // Criando a relação PatientEvaluation
        patientEvaluation = new PatientEvaluation();
        patientEvaluation.setPatient(patient);
        patientEvaluation.setEvaluation(evaluation);

        // Criando DTO correspondente
        evaluationDTO = EvaluationDTO.builder()
                .patientId(patientId)
                .mainComplaint("Speech delay")
                .evaluationData("Some evaluation data")
                .build();
    }

    @Test
    void shouldGetAllEvaluations() {
        when(evaluationRepository.findAll()).thenReturn(List.of(evaluation));
        when(evaluationMapper.convertToDTO(evaluation)).thenReturn(evaluationDTO);

        List<EvaluationDTO> evaluations = evaluationService.getAllEvaluations();

        assertNotNull(evaluations);
        assertEquals(1, evaluations.size());
        assertEquals("Speech delay", evaluations.get(0).getMainComplaint());
        verify(evaluationRepository, times(1)).findAll();
    }

    @Test
    void shouldGetEvaluationById() {
        when(evaluationRepository.findById(evaluationId)).thenReturn(Optional.of(evaluation));
        when(evaluationMapper.convertToDTO(evaluation)).thenReturn(evaluationDTO);

        EvaluationDTO foundEvaluation = evaluationService.getEvaluationById(evaluationId);

        assertNotNull(foundEvaluation);
        assertEquals("Speech delay", foundEvaluation.getMainComplaint());
        verify(evaluationRepository, times(1)).findById(evaluationId);
    }

    @Test
    void shouldThrowExceptionWhenEvaluationNotFound() {
        when(evaluationRepository.findById(evaluationId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> evaluationService.getEvaluationById(evaluationId));

        assertEquals("Evaluation not found with id: " + evaluationId, exception.getMessage());
        verify(evaluationRepository, times(1)).findById(evaluationId);
    }

    @Test
    void shouldCreateEvaluation() {
        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));
        when(evaluationMapper.convertToEntity(evaluationDTO, patient)).thenReturn(evaluation);
        when(evaluationRepository.save(any(Evaluation.class))).thenReturn(evaluation);
        when(evaluationMapper.convertToDTO(evaluation)).thenReturn(evaluationDTO);

        EvaluationDTO createdEvaluation = evaluationService.createEvaluation(evaluationDTO);

        assertNotNull(createdEvaluation);
        assertEquals("Speech delay", createdEvaluation.getMainComplaint());
        verify(patientRepository, times(1)).findById(patientId);
        verify(evaluationRepository, times(1)).save(any(Evaluation.class));
    }

    @Test
    void shouldThrowExceptionWhenPatientNotFound() {
        when(patientRepository.findById(patientId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> evaluationService.createEvaluation(evaluationDTO));

        assertEquals("Patient not found with id: " + patientId, exception.getMessage());
        verify(patientRepository, times(1)).findById(patientId);
        verify(evaluationRepository, never()).save(any(Evaluation.class));
    }

    @Test
    void shouldUpdateEvaluation() {
        when(evaluationRepository.findById(evaluationId)).thenReturn(Optional.of(evaluation));
        when(evaluationRepository.save(any(Evaluation.class))).thenReturn(evaluation);
        when(evaluationMapper.convertToDTO(evaluation)).thenReturn(evaluationDTO);

        EvaluationDTO updatedEvaluation = evaluationService.updateEvaluation(evaluationId, evaluationDTO);

        assertNotNull(updatedEvaluation);
        assertEquals("Speech delay", updatedEvaluation.getMainComplaint());
        verify(evaluationRepository, times(1)).findById(evaluationId);
        verify(evaluationRepository, times(1)).save(any(Evaluation.class));
    }

    @Test
    void shouldThrowExceptionWhenUpdatingNonExistentEvaluation() {
        when(evaluationRepository.findById(evaluationId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> evaluationService.updateEvaluation(evaluationId, evaluationDTO));

        assertEquals("Evaluation not found with id: " + evaluationId, exception.getMessage());
        verify(evaluationRepository, times(1)).findById(evaluationId);
        verify(evaluationRepository, never()).save(any(Evaluation.class));
    }

    @Test
    void shouldDeleteEvaluation() {
        when(evaluationRepository.findById(evaluationId)).thenReturn(Optional.of(evaluation));
        doNothing().when(evaluationRepository).delete(evaluation);

        assertDoesNotThrow(() -> evaluationService.deleteEvaluation(evaluationId));
        verify(evaluationRepository, times(1)).findById(evaluationId);
        verify(evaluationRepository, times(1)).delete(evaluation);
    }

    @Test
    void shouldThrowExceptionWhenDeletingNonExistentEvaluation() {
        when(evaluationRepository.findById(evaluationId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> evaluationService.deleteEvaluation(evaluationId));

        assertEquals("Evaluation not found with id: " + evaluationId, exception.getMessage());
        verify(evaluationRepository, times(1)).findById(evaluationId);
        verify(evaluationRepository, never()).delete(any(Evaluation.class));
    }
}
