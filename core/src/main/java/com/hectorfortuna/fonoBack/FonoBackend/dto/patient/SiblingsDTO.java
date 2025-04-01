package com.hectorfortuna.fonoBack.FonoBackend.dto.patient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SiblingsDTO {
    @JsonProperty("name")
    private String siblingsName;
    @JsonProperty("age")
    private String siblingsAge;
}