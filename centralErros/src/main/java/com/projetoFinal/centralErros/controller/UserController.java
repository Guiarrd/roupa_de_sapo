package com.projetoFinal.centralErros.controller;


import com.projetoFinal.centralErros.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/central-de-erros")
public class UserController {

    private final UserService userService;


    @GetMapping("/cadastrar")
    public String cadastro(){
        return "central-de-erros/cadastrar";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<> salvar(@Valid @RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok().build();;
    }
    @GetMapping("/logar")
    public String logar(){
        return "central-de-erros/logar";

    }

}
