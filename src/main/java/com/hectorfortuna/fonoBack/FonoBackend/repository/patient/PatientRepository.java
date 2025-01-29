package com.hectorfortuna.fonoBack.FonoBackend.repository.patient;

import com.hectorfortuna.fonoBack.FonoBackend.model.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}