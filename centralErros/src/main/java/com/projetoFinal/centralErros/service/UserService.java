package com.projetoFinal.centralErros.service;


import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
