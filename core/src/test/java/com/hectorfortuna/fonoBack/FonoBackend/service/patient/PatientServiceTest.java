package com.hectorfortuna.fonoBack.FonoBackend.service.patient;
import com.hectorfortuna.fonoBack.FonoBackend.dto.patient.AddressDTO;
import com.hectorfortuna.fonoBack.FonoBackend.dto.patient.PatientDTO;
import com.hectorfortuna.fonoBack.FonoBackend.dto.patient.SiblingsDTO;
import com.hectorfortuna.fonoBack.FonoBackend.model.patient.Address;
import com.hectorfortuna.fonoBack.FonoBackend.model.patient.Patient;
import com.hectorfortuna.fonoBack.FonoBackend.model.patient.Siblings;
import com.hectorfortuna.fonoBack.FonoBackend.repository.patient.PatientRepository;
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
class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    private UUID patientId;
    private Patient patient;
    private PatientDTO patientDTO;

    @BeforeEach
    void setUp() {
        patientId = UUID.randomUUID();

        Siblings siblings = Siblings.builder().siblingsAge("20").build();
        Address address = Address.builder().address("Rua das Palmeiras, 123").build();

        patient = Patient.builder()
                .id(patientId)
                .patientName("João da Silva")
                .fatherName("Carlos da Silva")
                .motherName("Maria da Silva")
                .birthDate("2005-06-15")
                .patientAge("18")
                .phoneNumber("(11) 98765-4321")
                .motherCareer("Estudante")
                .siblings(siblings)
                .address(address)
                .build();

        patientDTO = PatientDTO.builder()
                .id(patientId)
                .patientName("João da Silva")
                .fatherName("Carlos da Silva")
                .motherName("Maria da Silva")
                .birthDate("2005-06-15")
                .patientAge("18")
                .phoneNumber("(11) 98765-4321")
                .motherCareer("Estudante")
                .siblings(SiblingsDTO.builder().siblingsAge("20").build())
                .address(AddressDTO.builder().address("Rua das Palmeiras, 123").build())
                .build();
    }

    @Test
    void shouldGetAllPatients() {
        when(patientRepository.findAll()).thenReturn(List.of(patient));

        List<PatientDTO> patients = patientService.getAllPatients();

        assertNotNull(patients);
        assertEquals(1, patients.size());
        assertEquals("João da Silva", patients.get(0).getPatientName());
        verify(patientRepository, times(1)).findAll();
    }

    @Test
    void shouldGetPatientById() {
        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));

        PatientDTO foundPatient = patientService.getPatientById(patientId);

        assertNotNull(foundPatient);
        assertEquals(patientId, foundPatient.getId());
        assertEquals("João da Silva", foundPatient.getPatientName());
        verify(patientRepository, times(1)).findById(patientId);
    }

    @Test
    void shouldThrowExceptionWhenPatientNotFound() {
        when(patientRepository.findById(patientId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> patientService.getPatientById(patientId));

        assertEquals("Patient not found with id: " + patientId, exception.getMessage());
        verify(patientRepository, times(1)).findById(patientId);
    }

    @Test
    void shouldCreatePatient() {
        when(patientRepository.save(any(Patient.class))).thenReturn(patient);

        PatientDTO createdPatient = patientService.createPatient(patientDTO);

        assertNotNull(createdPatient);
        assertEquals("João da Silva", createdPatient.getPatientName());
        assertEquals("Carlos da Silva", createdPatient.getFatherName());
        verify(patientRepository, times(1)).save(any(Patient.class));
    }

    @Test
    void shouldUpdatePatient() {
        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));
        when(patientRepository.save(any(Patient.class))).thenReturn(patient);

        PatientDTO updatedPatient = patientService.updatePatient(patientId, patientDTO);

        assertNotNull(updatedPatient);
        assertEquals("João da Silva", updatedPatient.getPatientName());
        verify(patientRepository, times(1)).findById(patientId);
        verify(patientRepository, times(1)).save(any(Patient.class));
    }

    @Test
    void shouldThrowExceptionWhenUpdatingNonExistentPatient() {
        when(patientRepository.findById(patientId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> patientService.updatePatient(patientId, patientDTO));

        assertEquals("Patient not found with id: " + patientId, exception.getMessage());
        verify(patientRepository, times(1)).findById(patientId);
        verify(patientRepository, never()).save(any(Patient.class));
    }

    @Test
    void shouldDeletePatient() {
        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));
        doNothing().when(patientRepository).delete(patient);

        assertDoesNotThrow(() -> patientService.deletePatient(patientId));
        verify(patientRepository, times(1)).findById(patientId);
        verify(patientRepository, times(1)).delete(patient);
    }

    @Test
    void shouldThrowExceptionWhenDeletingNonExistentPatient() {
        when(patientRepository.findById(patientId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> patientService.deletePatient(patientId));

        assertEquals("Patient not found with id: " + patientId, exception.getMessage());
        verify(patientRepository, times(1)).findById(patientId);
        verify(patientRepository, never()).delete(any(Patient.class));
    }
}