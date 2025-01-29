package com.hectorfortuna.fonoBack.FonoBackend.dto.patient;

import lombok.Builder;
import lombok.Data;

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
    private SiblingsDTO siblings;
    private AddressDTO address;
}
