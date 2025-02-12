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

import java.util.ArrayList;
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
        // Criação de um novo objeto Patient com base no PatientDTO
        Patient patient = Patient.builder()
                .id(patientDTO.getId())
                .patientName(patientDTO.getPatientName())
                .fatherName(patientDTO.getFatherName())
                .motherName(patientDTO.getMotherName())
                .birthDate(patientDTO.getBirthDate())
                .patientAge(patientDTO.getPatientAge())
                .phoneNumber(patientDTO.getPhoneNumber())
                .career(patientDTO.getCareer())
                .build();

        // Se a lista de irmãos não for nula nem vazia, adiciona os Siblings
        if (patientDTO.getSiblings() != null && !patientDTO.getSiblings().isEmpty()) {
            List<Siblings> siblingsList = patientDTO.getSiblings().stream()
                    .map(siblingDTO -> Siblings.builder()
                            .siblingsName(siblingDTO.getSiblingsName())
                            .siblingsAge(siblingDTO.getSiblingsAge())
                            .build())
                    .collect(Collectors.toList());
            patient.setSiblings(siblingsList);
        } else {
            patient.setSiblings(new ArrayList<>());  // Garantir que a lista de irmãos não seja null
        }

        // Se a lista de endereços não for nula nem vazia, adiciona os Addresses
        if (patientDTO.getAddress() != null && !patientDTO.getAddress().isEmpty()) {
            List<Address> addressList = patientDTO.getAddress().stream()
                    .map(addressDTO -> Address.builder()
                            .street(addressDTO.getStreet())
                            .number(addressDTO.getNumber())
                            .neighborhood(addressDTO.getNeighborhood())
                            .city(addressDTO.getCity())
                            .state(addressDTO.getState())
                            .cep(addressDTO.getCep())
                            .build())
                    .collect(Collectors.toList());
            patient.setAddress(addressList);
        } else {
            patient.setAddress(new ArrayList<>());  // Garantir que a lista de endereços não seja null
        }

        // Salva o paciente no banco de dados
        patient = patientRepository.save(patient);

        // Retorna o PatientDTO com os dados do paciente criado
        return PatientDTO.builder()
                .id(patient.getId())
                .patientName(patient.getPatientName())
                .fatherName(patient.getFatherName())
                .motherName(patient.getMotherName())
                .birthDate(patient.getBirthDate())
                .patientAge(patient.getPatientAge())
                .phoneNumber(patient.getPhoneNumber())
                .career(patient.getCareer())
                .siblings(patient.getSiblings().stream()
                        .map(sibling -> SiblingsDTO.builder()
                                .siblingsName(sibling.getSiblingsName())
                                .siblingsAge(sibling.getSiblingsAge())
                                .build())
                        .collect(Collectors.toList()))
                .address(patient.getAddress().stream()
                        .map(address -> AddressDTO.builder()
                                .street(address.getStreet())
                                .number(address.getNumber())
                                .neighborhood(address.getNeighborhood())
                                .city(address.getCity())
                                .state(address.getState())
                                .cep(address.getCep())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }



    /**
     * Atualiza um paciente existente
     */
    @Transactional
    public PatientDTO updatePatient(UUID id, PatientDTO patientDTO) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        // Atualizando os valores existentes
        patient.setSiblings(patientDTO.getSiblings().stream()
                .map(siblingDTO -> Siblings.builder()
                        .siblingsName(siblingDTO.getSiblingsName())
                        .siblingsAge(siblingDTO.getSiblingsAge())
                        .build())
                .collect(Collectors.toList()));

        patient.setAddress(patientDTO.getAddress().stream()
                .map(addressDTO -> Address.builder()
                        .street(addressDTO.getStreet())
                        .number(addressDTO.getNumber())
                        .neighborhood(addressDTO.getNeighborhood())
                        .city(addressDTO.getCity())
                        .state(addressDTO.getState())
                        .cep(addressDTO.getCep())
                        .build())
                .collect(Collectors.toList()));

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
                .siblings(patient.getSiblings().stream()
                        .map(sibling -> SiblingsDTO.builder()
                                .siblingsName(sibling.getSiblingsName())
                                .siblingsAge(sibling.getSiblingsAge())
                                .build())
                        .collect(Collectors.toList()))
                .address(patient.getAddress().stream()
                        .map(address -> AddressDTO.builder()
                                .street(address.getStreet())
                                .number(address.getNumber())
                                .neighborhood(address.getNeighborhood())
                                .city(address.getCity())
                                .state(address.getState())
                                .cep(address.getCep())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
