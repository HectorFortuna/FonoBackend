package com.hectorfortuna.fonoBack.FonoBackend.controller;

import com.hectorfortuna.fonoBack.FonoBackend.model.RegisterModel;
import com.hectorfortuna.fonoBack.FonoBackend.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/register")
public class RegisterController {

    @Autowired
    private
    RegisterRepository registerRepository;

    @PostMapping
    public ResponseEntity<RegisterModel> createRegister(@RequestBody RegisterModel registerModel) {
        RegisterModel savedRegister = registerRepository.save(registerModel);
        return new ResponseEntity<>(savedRegister, HttpStatus.CREATED);
    }
}
