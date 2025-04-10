package com.hectorfortuna.fonoBack.FonoBackend.repository.patient;

import com.hectorfortuna.fonoBack.FonoBackend.model.patient.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}