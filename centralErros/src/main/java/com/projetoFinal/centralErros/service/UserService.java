package com.projetoFinal.centralErros.service;


import com.projetoFinal.centralErros.dto.UserDTO;
import com.projetoFinal.centralErros.mapper.UserMapper;
import com.projetoFinal.centralErros.model.User;
import com.projetoFinal.centralErros.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository userRepository;

    //Encontra usuário por id
    public UserDTO findUserById(Long id) {
        return UserMapper.toUserDTO(userRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Nenhum usuário encontrado.",User.class.getName())));
    }

    //Retorna todos os usuários
    public List<UserDTO> findAllUsers() {
        return UserMapper.toListUserDTO(userRepository.findAll());
    }

    public UserDTO findByEmail(String email) {
        return UserMapper.toUserDTO(userRepository.findByEmail(email).orElseThrow(()-> new ObjectNotFoundException("Nenhum usuário encontrado.",User.class.getName())));
    }

    //Cria usuário/atualiza usuário
    public void saveUser(User user) {
        userRepository.save(user);
    }

    //Deleta usuário por id
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Nenhum usuário encontrado.",User.class.getName()));
        userRepository.delete(user);
    }
}
