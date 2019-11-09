package com.projetoFinal.centralErros.service;


import com.projetoFinal.centralErros.model.User;
import com.projetoFinal.centralErros.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository userRepository;

    //Encontra usuário por id
    public User findUserById(Long id) {
        return userRepository.findById(id);
    }
    //Retorna todos os usuários
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    //Cria usuário/atualiza usuário
    public void saveUser(User user) {
        userRepository.save(user);
    }
    //Deleta usuário por id
    public void deleteUser(Long id) {
        User user = findUserById(id);
        userRepository.delete(user);
    }






}
