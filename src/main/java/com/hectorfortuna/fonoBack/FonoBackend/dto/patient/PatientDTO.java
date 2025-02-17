package com.hectorfortuna.fonoBack.FonoBackend.dto.patient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class PatientDTO {
    private UUID id;
    @JsonProperty("name")
    private String patientName;
    @JsonProperty("fatherName")
    private String fatherName;
    @JsonProperty("motherName")
    private String motherName;
    @JsonProperty("birthDate")
    private String birthDate;
    @JsonProperty("age")
    private String patientAge;
    @JsonProperty("phone")
    private String phoneNumber;
    @JsonProperty("career")
    private String career;
    @JsonProperty("school")
    private String school;

    private List<SiblingsDTO> siblings;
    private List<AddressDTO> address;
}
