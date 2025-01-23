package com.hectorfortuna.fonoBack.FonoBackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hectorfortuna.fonoBack.FonoBackend.model.RegisterModel;
import com.hectorfortuna.fonoBack.FonoBackend.repository.RegisterRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RegisterRepository registerRepository;

    private RegisterModel register;

    @BeforeEach
    public void setup() {
        register = new RegisterModel("Name", "01/01/1990", "31", "Father Name", "Mother Name", "Career", "Address", "123456789");
        registerRepository.save(register);
    }

    @Test
    public void shouldReturnAllRegisterSuccessfully() throws Exception {
        mockMvc.perform(get("/api/register"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(Matchers.greaterThan(0)));
    }

    @Test
    public void shouldCreateRegisterSuccessfully() throws Exception{
        RegisterModel newRegister = new RegisterModel("New Name", "02/02/1985", "45", "Father New", "Mother New", "Engineer", "New Address", "987654321");
        mockMvc.perform(post("/api/register")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(newRegister)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());

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
