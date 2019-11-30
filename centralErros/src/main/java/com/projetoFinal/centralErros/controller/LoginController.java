package com.projetoFinal.centralErros.controller;

import com.projetoFinal.centralErros.dto.LogDTO;
import com.projetoFinal.centralErros.mapper.LogMapper;
import com.projetoFinal.centralErros.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/login")
public class LoginController {


    @PostMapping
    public ResponseEntity<HttpStatus> login(@Valid @RequestBody Object userData) {
        return new ResponseEntity<>(HttpStatus.OK);

    }

    }