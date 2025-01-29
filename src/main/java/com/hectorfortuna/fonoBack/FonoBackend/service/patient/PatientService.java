package com.hectorfortuna.fonoBack.FonoBackend.service.patient;

import com.hectorfortuna.fonoBack.FonoBackend.dto.patient.AddressDTO;
import com.hectorfortuna.fonoBack.FonoBackend.dto.patient.PatientDTO;
import com.hectorfortuna.fonoBack.FonoBackend.dto.patient.SiblingsDTO;
import com.hectorfortuna.fonoBack.FonoBackend.model.patient.Address;
import com.hectorfortuna.fonoBack.FonoBackend.model.patient.Patient;
import com.hectorfortuna.fonoBack.FonoBackend.model.patient.Siblings;
import com.hectorfortuna.fonoBack.FonoBackend.repository.patient.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    /**
     * Obtém todos os pacientes e converte para DTOs
     */
    @Transactional(readOnly = true)
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Obtém um paciente por ID e converte para DTO
     */
    @Transactional(readOnly = true)
    public PatientDTO getPatientById(UUID id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        return convertToDTO(patient);
    }

    /**
     * Cria um novo paciente junto com Address e Siblings
     */
    @Transactional
    public PatientDTO createPatient(PatientDTO patientDTO) {
        // Convertendo DTOs para entidades
        Siblings siblings = Siblings.builder()
                .siblingsAge(patientDTO.getSiblings().getSiblingsAge())
                .build();

        Address address = Address.builder()
                .address(patientDTO.getAddress().getAddress())
                .build();

        // Criando o Patient com as entidades criadas
        Patient patient = Patient.builder()
                .siblings(siblings)
                .address(address)
                .patientName(patientDTO.getPatientName())
                .fatherName(patientDTO.getFatherName())
                .motherName(patientDTO.getMotherName())
                .birthDate(patientDTO.getBirthDate())
                .patientAge(patientDTO.getPatientAge())
                .phoneNumber(patientDTO.getPhoneNumber())
                .career(patientDTO.getCareer())
                .build();

        patient = patientRepository.save(patient);
        return convertToDTO(patient);
    }

    /**
     * Atualiza um paciente existente
     */
    @Transactional
    public PatientDTO updatePatient(UUID id, PatientDTO patientDTO) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        // Atualizando os valores existentes
        patient.getSiblings().setSiblingsAge(patientDTO.getSiblings().getSiblingsAge());
        patient.getAddress().setAddress(patientDTO.getAddress().getAddress());
        patient.setPatientName(patientDTO.getPatientName());
        patient.setFatherName(patientDTO.getFatherName());
        patient.setMotherName(patientDTO.getMotherName());
        patient.setBirthDate(patientDTO.getBirthDate());
        patient.setPatientAge(patientDTO.getPatientAge());
        patient.setPhoneNumber(patientDTO.getPhoneNumber());
        patient.setCareer(patientDTO.getCareer());

        patient = patientRepository.save(patient);
        return convertToDTO(patient);
    }

    /**
     * Deleta um paciente pelo ID
     */
    @Transactional
    public void deletePatient(UUID id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        patientRepository.delete(patient);
    }

    /**
     * Converte uma entidade Patient para DTO
     */
    private PatientDTO convertToDTO(Patient patient) {
        return PatientDTO.builder()
                .id(patient.getId())
                .patientName(patient.getPatientName())
                .fatherName(patient.getFatherName())
                .motherName(patient.getMotherName())
                .birthDate(patient.getBirthDate())
                .patientAge(patient.getPatientAge())
                .phoneNumber(patient.getPhoneNumber())
                .career(patient.getCareer())
                .siblings(SiblingsDTO.builder()
                        .siblingsAge(patient.getSiblings().getSiblingsAge())
                        .build())
                .address(AddressDTO.builder()
                        .address(patient.getAddress().getAddress())
                        .build())
                .build();
    }
}