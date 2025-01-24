package com.hectorfortuna.fonoBack.FonoBackend.controller;

import com.hectorfortuna.fonoBack.FonoBackend.model.RegisterModel;
import com.hectorfortuna.fonoBack.FonoBackend.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/register")
public class RegisterController {

    @Autowired
    private
    RegisterRepository registerRepository;

    @PostMapping
    public ResponseEntity<RegisterModel> createRegister(@RequestBody RegisterModel registerModel) {
        RegisterModel savedRegister = registerRepository.save(registerModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRegister);
    }

    @GetMapping
    public ResponseEntity<List<RegisterModel>> getAllRegister(){
        List<RegisterModel> registers = registerRepository.findAll();
        return ResponseEntity.ok(registers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegisterModel> getRegisterById(@PathVariable UUID id){
        if(!registerRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        RegisterModel byId = registerRepository.findById(id).get();
        return ResponseEntity.ok(byId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegisterModel> putRegister(@RequestBody RegisterModel registerModel, @PathVariable UUID id){
        if(!registerRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        registerModel.setId(id);
        registerRepository.save(registerModel);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RegisterModel> deleteRegister(@PathVariable UUID id){
        if(!registerRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        registerRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
