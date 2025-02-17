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
        // Criando o objeto Patient com base no DTO
        final Patient patient = Patient.builder()
                .patientName(patientDTO.getPatientName())
                .fatherName(patientDTO.getFatherName())
                .motherName(patientDTO.getMotherName())
                .birthDate(patientDTO.getBirthDate())
                .patientAge(patientDTO.getPatientAge())
                .phoneNumber(patientDTO.getPhoneNumber())
                .career(patientDTO.getCareer())
                .school(patientDTO.getSchool())
                .build();

        // ✅ Associando Siblings ao Patient (Corrigido)
        if (patientDTO.getSiblings() != null && !patientDTO.getSiblings().isEmpty()) {
            List<Siblings> siblingsList = patientDTO.getSiblings().stream()
                    .map(siblingDTO -> {
                        Siblings sibling = Siblings.builder()
                                .siblingsName(siblingDTO.getSiblingsName())
                                .siblingsAge(siblingDTO.getSiblingsAge())
                                .build();
                        sibling.setPatient(patient); // ⬅️ Variável patient agora é final
                        return sibling;
                    })
                    .collect(Collectors.toList());
            patient.setSiblings(siblingsList);
        } else {
            patient.setSiblings(new ArrayList<>());
        }

        // ✅ Associando Address ao Patient (Corrigido)
        if (patientDTO.getAddress() != null && !patientDTO.getAddress().isEmpty()) {
            List<Address> addressList = patientDTO.getAddress().stream()
                    .map(addressDTO -> {
                        Address address = Address.builder()
                                .street(addressDTO.getStreet())
                                .number(addressDTO.getNumber())
                                .neighborhood(addressDTO.getNeighborhood())
                                .city(addressDTO.getCity())
                                .state(addressDTO.getState())
                                .cep(addressDTO.getCep())
                                .build();
                        address.setPatient(patient); // ⬅️ Variável patient agora é final
                        return address;
                    })
                    .collect(Collectors.toList());
            patient.setAddresses(addressList);
        } else {
            patient.setAddresses(new ArrayList<>());
        }

        // ✅ Agora o Patient está corretamente associado aos Siblings e Addresses
        Patient savedPatient = patientRepository.save(patient);

        return convertToDTO(savedPatient);
    }






    /**
     * Atualiza um paciente existente
     */
    @Transactional
    public PatientDTO updatePatient(UUID id, PatientDTO patientDTO) {
        final Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        // Atualizando os valores existentes
        patient.setPatientName(patientDTO.getPatientName());
        patient.setFatherName(patientDTO.getFatherName());
        patient.setMotherName(patientDTO.getMotherName());
        patient.setBirthDate(patientDTO.getBirthDate());
        patient.setPatientAge(patientDTO.getPatientAge());
        patient.setPhoneNumber(patientDTO.getPhoneNumber());
        patient.setCareer(patientDTO.getCareer());
        patient.setSchool(patientDTO.getSchool());

        // ✅ Atualiza e vincula Siblings
        if (patientDTO.getSiblings() != null) {
            List<Siblings> updatedSiblings = patientDTO.getSiblings().stream()
                    .map(siblingDTO -> {
                        Siblings sibling = Siblings.builder()
                                .siblingsName(siblingDTO.getSiblingsName())
                                .siblingsAge(siblingDTO.getSiblingsAge())
                                .build();
                        sibling.setPatient(patient);
                        return sibling;
                    })
                    .collect(Collectors.toList());
            patient.setSiblings(updatedSiblings);
        } else {
            patient.setSiblings(new ArrayList<>());
        }

        // ✅ Atualiza e vincula Address
        if (patientDTO.getAddress() != null) {
            List<Address> updatedAddresses = patientDTO.getAddress().stream()
                    .map(addressDTO -> {
                        Address address = Address.builder()
                                .street(addressDTO.getStreet())
                                .number(addressDTO.getNumber())
                                .neighborhood(addressDTO.getNeighborhood())
                                .city(addressDTO.getCity())
                                .state(addressDTO.getState())
                                .cep(addressDTO.getCep())
                                .build();
                        address.setPatient(patient);
                        return address;
                    })
                    .collect(Collectors.toList());
            patient.setAddresses(updatedAddresses);
        } else {
            patient.setAddresses(new ArrayList<>());
        }

        Patient updatedPatient = patientRepository.save(patient);
        return convertToDTO(updatedPatient);
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
                .school(patient.getSchool())
                .career(patient.getCareer())
                .siblings(patient.getSiblings().stream()
                        .map(sibling -> SiblingsDTO.builder()
                                .siblingsName(sibling.getSiblingsName())
                                .siblingsAge(sibling.getSiblingsAge())
                                .build())
                        .collect(Collectors.toList()))
                .address(patient.getAddresses().stream()
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
