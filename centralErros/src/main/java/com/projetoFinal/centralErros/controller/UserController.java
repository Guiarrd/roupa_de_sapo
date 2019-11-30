package com.projetoFinal.centralErros.controller;

import com.projetoFinal.centralErros.dto.UserDTO;
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
    @PostMapping
    public ResponseEntity<HttpStatus> saveUser(@Valid @RequestBody UserDTO userDTO) {
        userService.saveUser(UserMapper.toUser(userDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<HttpStatus> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable Long userId) {
        User user = UserMapper.toUser(userDTO);
        user.setId(userId);
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        System.out.println("Acessado /api/v1/user");
        return new ResponseEntity<>(UserMapper.toListUser(userService.findAllUsers()), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable Long userId) {
        return new ResponseEntity<>(UserMapper.toUser(userService.findUserById(userId)), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        return new ResponseEntity<>(UserMapper.toUser(userService.findByEmail(email)), HttpStatus.OK);
    }
}
