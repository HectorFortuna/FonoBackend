package com.hectorfortuna.fonoBack.FonoBackend.dto.patient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String cep;
 }