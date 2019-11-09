package com.projetoFinal.centralErros.mapper;

import com.projetoFinal.centralErros.dto.UserDTO;
import com.projetoFinal.centralErros.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    private UserMapper() {
        super(); //define que esta classe não pode ser instanciada
    }

    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFullName(user.getFullName());
        userDTO.setPassword(user.getPassword());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }

    public static User toUser(UserDTO userDTO) {
        User user = new User();

        user.setId(userDTO.getId());
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAvatar(userDTO.getAvatar());

        return user;
    }

    public static List<UserDTO> toListUserDTO(List<User> users) {
        return users.stream().map(UserMapper::toUserDTO).collect(Collectors.toList());
    }

    public static List<User> toListUser(List<UserDTO> userDTOS) {
        return userDTOS.stream().map(UserMapper::toUser).collect(Collectors.toList());
    }
}
