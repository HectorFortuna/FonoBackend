package com.hectorfortuna.fonoBack.FonoBackend.repository;

import com.hectorfortuna.fonoBack.FonoBackend.model.RegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegisterRepository extends JpaRepository<RegisterModel, UUID> {
}