package com.hectorfortuna.fonoBack.FonoBackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hectorfortuna.fonoBack.FonoBackend.model.RegisterModel;
import com.hectorfortuna.fonoBack.FonoBackend.repository.RegisterRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RegisterRepository registerRepository;

    private RegisterModel register;

    @BeforeEach
    public void setup() {
        UUID fixedId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");

        register = new RegisterModel("Name", "01/01/1990", "31", "Father Name", "Mother Name", "Career", "Address", "123456789");
        register.setId(fixedId);

        Mockito.when(registerRepository.save(Mockito.any(RegisterModel.class))).thenReturn(register);
        Mockito.when(registerRepository.findById(fixedId)).thenReturn(Optional.of(register));
        Mockito.when(registerRepository.existsById(fixedId)).thenReturn(true);
    }

    @Test
    public void shouldReturnAllRegisterSuccessfully() throws Exception {
        Mockito.when(registerRepository.findAll()).thenReturn(List.of(register));

        mockMvc.perform(get("/api/register"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(Matchers.greaterThan(0)));
    }

    @Test
    public void shouldCreateRegisterSuccessfully() throws Exception{
        RegisterModel newRegister = new RegisterModel("New Name", "02/02/1985", "45", "Father New", "Mother New", "Engineer", "New Address", "987654321");
        newRegister.setId(UUID.randomUUID());

        Mockito.when(registerRepository.save(Mockito.any(RegisterModel.class))).thenReturn(newRegister);

        mockMvc.perform(post("/api/register")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(newRegister)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").isNotEmpty());
    }


    @Test
    public void shouldReturnRegisterByIdSuccessfully() throws Exception {
        UUID validId = register.getId();

        mockMvc.perform(get("/api/register/{id}", validId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(validId.toString()));
    }
    @Test
    public void shouldReturn404WhenRegisterNotFound() throws Exception {
        UUID invalidId = UUID.randomUUID();
        mockMvc.perform(get("/api/register/{id}", invalidId))
                .andExpect(status().isNotFound());

    }

    @Test
    public void shouldUpdateRegisterSuccessfully() throws Exception {
        UUID validId = register.getId();
        RegisterModel updatedRegister = new RegisterModel("Updated Name", "01/01/1985", "22", "Updated Father", "Updated Mother", "Updated Career", "Updated Address", "111222333");

        mockMvc.perform(put("/api/register/{id}", validId)
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(updatedRegister)))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturn404WhenUpdatingNonExistentRegister() throws Exception {
        UUID invalidId = UUID.randomUUID();
        RegisterModel updatedRegister = new RegisterModel("Updated Name", "01/01/1985", "22", "Updated Father", "Updated Mother", "Updated Career", "Updated Address", "111222333");

        mockMvc.perform(put("/api/register/{id}", invalidId)
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(updatedRegister)))
                .andExpect(status().isNotFound());
    }


    @Test
    public void shouldDeleteRegisterSuccessfully() throws Exception {
        UUID validId = register.getId();

        mockMvc.perform(delete("/api/register/{id}", validId))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturn404WhenDeletingNonExistentRegister() throws Exception {
        UUID invalidId = UUID.randomUUID();

        mockMvc.perform(delete("/api/register/{id}", invalidId))
                .andExpect(status().isNotFound());
    }
}
