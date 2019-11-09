package com.projetoFinal.centralErros.service;


import com.projetoFinal.centralErros.model.Log;
import com.projetoFinal.centralErros.model.User;
import com.projetoFinal.centralErros.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository userRepository;

    //Encontra usuário por id
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("No user found by id",User.class.getName()));
    }

    //Retorna todos os usuários
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()-> new ObjectNotFoundException("No user found by email",User.class.getName()));
    }
    //Cria usuário/atualiza usuário
    public void saveUser(User user) {
        userRepository.save(user);
    }
    //Deleta usuário por id
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("User does not exist",User.class.getName()));
        userRepository.delete(user);
    }






}
