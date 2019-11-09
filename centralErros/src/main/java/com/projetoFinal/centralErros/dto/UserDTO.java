package com.projetoFinal.centralErros.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 6389937299445578637L;

    private Long id;
    @NotNull
    private String fullName;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String password;
    @Nullable
    private String avatar;

    private List<LogDTO> logs = new ArrayList<>();

}
