package com.hectorfortuna.fonoBack.FonoBackend.dto.patient;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class PatientDTO {
    private UUID id;
    private String patientName;
    private String fatherName;
    private String motherName;
    private String birthDate;
    private String patientAge;
    private String phoneNumber;
    private String career;
    private List<SiblingsDTO> siblings;
    private List<AddressDTO> address;
}
