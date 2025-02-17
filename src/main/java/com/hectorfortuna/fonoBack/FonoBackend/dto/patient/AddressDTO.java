package com.hectorfortuna.fonoBack.FonoBackend.dto.patient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {
    @JsonProperty("street")
    private String street;
    @JsonProperty("number")
    private String number;
    @JsonProperty("neighborhood")
    private String neighborhood;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("cep")
    private String cep;
 }