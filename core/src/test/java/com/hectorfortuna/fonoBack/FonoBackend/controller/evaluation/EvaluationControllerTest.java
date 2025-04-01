package com.hectorfortuna.fonoBack.FonoBackend.controller.evaluation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hectorfortuna.fonoBack.FonoBackend.dto.evaluation.EvaluationDTO;
import com.hectorfortuna.fonoBack.FonoBackend.service.evaluation.EvaluationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class EvaluationControllerTest {

    @Mock
    private EvaluationService evaluationService;

    @InjectMocks
    private EvaluationController evaluationController;

    private MockMvc mockMvc;
    private UUID evaluationId;
    private EvaluationDTO evaluationDTO;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(evaluationController).build();
        evaluationId = UUID.randomUUID();

        evaluationDTO = EvaluationDTO.builder()
                .id(evaluationId)
                .patientId(UUID.randomUUID())
                .mainComplaint("Speech delay")
                .evaluationData("Some evaluation data")
                .build();
    }

    @Test
    void shouldGetAllEvaluations() throws Exception {
        when(evaluationService.getAllEvaluations()).thenReturn(List.of(evaluationDTO));

        mockMvc.perform(get("/api/evaluations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].mainComplaint").value("Speech delay"));

        verify(evaluationService, times(1)).getAllEvaluations();
    }

    @Test
    void shouldGetEvaluationById() throws Exception {
        when(evaluationService.getEvaluationById(evaluationId)).thenReturn(evaluationDTO);

        mockMvc.perform(get("/api/evaluations/{id}", evaluationId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mainComplaint").value("Speech delay"));

        verify(evaluationService, times(1)).getEvaluationById(evaluationId);
    }

    @Test
    void shouldCreateEvaluation() throws Exception {
        when(evaluationService.createEvaluation(any(EvaluationDTO.class))).thenReturn(evaluationDTO);

        mockMvc.perform(post("/api/evaluations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(evaluationDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mainComplaint").value("Speech delay"));

        verify(evaluationService, times(1)).createEvaluation(any(EvaluationDTO.class));
    }

    @Test
    void shouldUpdateEvaluation() throws Exception {
        when(evaluationService.updateEvaluation(eq(evaluationId), any(EvaluationDTO.class)))
                .thenReturn(evaluationDTO);

        mockMvc.perform(put("/api/evaluations/{id}", evaluationId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(evaluationDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mainComplaint").value("Speech delay"));

        verify(evaluationService, times(1)).updateEvaluation(eq(evaluationId), any(EvaluationDTO.class));
    }

    @Test
    void shouldDeleteEvaluation() throws Exception {
        doNothing().when(evaluationService).deleteEvaluation(evaluationId);

        mockMvc.perform(delete("/api/evaluations/{id}", evaluationId))
                .andExpect(status().isNoContent());

        verify(evaluationService, times(1)).deleteEvaluation(evaluationId);
    }
}
