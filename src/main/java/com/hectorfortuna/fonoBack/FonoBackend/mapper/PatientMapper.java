package com.hectorfortuna.fonoBack.FonoBackend.mapper;

import com.hectorfortuna.fonoBack.FonoBackend.dto.patient.PatientDTO;
import com.hectorfortuna.fonoBack.FonoBackend.model.patient.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public PatientDTO convertToDTO(Patient patient) {
        return PatientDTO.builder()
                .id(patient.getId())  // 🔥 Inclui o ID gerado automaticamente
                .patientName(patient.getPatientName())
                .fatherName(patient.getFatherName())
                .motherName(patient.getMotherName())
                .birthDate(patient.getBirthDate())
                .patientAge(patient.getPatientAge())
                .phoneNumber(patient.getPhoneNumber())
                .build();
    }

    public Patient convertToEntity(PatientDTO patientDTO) {
        return Patient.builder()
                .patientName(patientDTO.getPatientName())
                .fatherName(patientDTO.getFatherName())
                .motherName(patientDTO.getMotherName())
                .birthDate(patientDTO.getBirthDate())
                .patientAge(patientDTO.getPatientAge())
                .phoneNumber(patientDTO.getPhoneNumber())
                .build();
    }
}
