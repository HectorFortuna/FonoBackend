package com.hectorfortuna.fonoBack.FonoBackend.dto.patient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {
    private String address;
}