package com.hectorfortuna.fonoBack.FonoBackend.controller.patient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hectorfortuna.fonoBack.FonoBackend.dto.patient.PatientDTO;
import com.hectorfortuna.fonoBack.FonoBackend.service.patient.PatientService;
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
class PatientControllerTest {

    @Mock
    private PatientService patientService;

    @InjectMocks
    private PatientController patientController;

    private MockMvc mockMvc;
    private UUID patientId;
    private PatientDTO patientDTO;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
        patientId = UUID.randomUUID();

        patientDTO = PatientDTO.builder()
                .id(patientId)
                .patientName("John Doe")
                .fatherName("Father Doe")
                .motherName("Mother Doe")
                .birthDate("2005-06-15")
                .patientAge("18")
                .phoneNumber("(11) 98765-4321")
                .career("Student")
                .build();
    }

    @Test
    void shouldGetAllPatients() throws Exception {
        when(patientService.getAllPatients()).thenReturn(List.of(patientDTO));

        mockMvc.perform(get("/api/patients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].patientName").value("John Doe"));

        verify(patientService, times(1)).getAllPatients();
    }

    @Test
    void shouldGetPatientById() throws Exception {
        when(patientService.getPatientById(patientId)).thenReturn(patientDTO);

        mockMvc.perform(get("/api/patients/{id}", patientId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.patientName").value("John Doe"));

        verify(patientService, times(1)).getPatientById(patientId);
    }

    @Test
    void shouldCreatePatient() throws Exception {
        when(patientService.createPatient(any(PatientDTO.class))).thenReturn(patientDTO);

        mockMvc.perform(post("/api/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(patientDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.patientName").value("John Doe"));

        verify(patientService, times(1)).createPatient(any(PatientDTO.class));
    }

    @Test
    void shouldUpdatePatient() throws Exception {
        when(patientService.updatePatient(eq(patientId), any(PatientDTO.class)))
                .thenReturn(patientDTO);

        mockMvc.perform(put("/api/patients/{id}", patientId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(patientDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.patientName").value("John Doe"));

        verify(patientService, times(1)).updatePatient(eq(patientId), any(PatientDTO.class));
    }

    @Test
    void shouldDeletePatient() throws Exception {
        doNothing().when(patientService).deletePatient(patientId);

        mockMvc.perform(delete("/api/patients/{id}", patientId))
                .andExpect(status().isNoContent());

        verify(patientService, times(1)).deletePatient(patientId);
    }
}
