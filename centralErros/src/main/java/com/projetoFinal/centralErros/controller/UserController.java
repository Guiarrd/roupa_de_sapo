package com.projetoFinal.centralErros.controller;

import com.projetoFinal.centralErros.mapper.UserMapper;
import com.projetoFinal.centralErros.model.User;
import com.projetoFinal.centralErros.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping // acessar /user via POST para cadastrar um usuário
    public ResponseEntity<HttpStatus> saveUser(@Valid @RequestBody User user){
        System.out.println("acessado post /v1/user");
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{userId}") // acessar /user/id via PUT para atualizar um usuário
    public ResponseEntity<HttpStatus> updateUser(@Valid @RequestBody User user, @PathVariable Long userId) {
        user.setId(userId);
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping // acessar /user via GET para listar todos os usuários
    public ResponseEntity<List<User>> findAllUsers() {
        System.out.println("Acessado /api/v1/user");
        return new ResponseEntity <>(UserMapper.toListUser(userService.findAllUsers()), HttpStatus.OK);
    }

    @GetMapping("/{userId}") // acessar /user/id via GET para listar um usuário
    public ResponseEntity<User> findUserById(@PathVariable Long userId){
        return new ResponseEntity<>(UserMapper.toUser(userService.findUserById(userId)), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}") // acessar /delete/id via DELETE para deletar um usuário
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET, params = "email") // acessar /user?email=EMAIL via GET para listar um usuário pelo seu e-mail
    public ResponseEntity<User> findByEmail(@RequestParam(value="email", required = false) String email) {
        return new ResponseEntity<>(UserMapper.toUser(userService.findByEmail(email)), HttpStatus.OK);
    }
}
