package com.projetoFinal.centralErros.dto;

import com.projetoFinal.centralErros.enums.EnvironmentEnum;
import com.projetoFinal.centralErros.enums.LevelEnum;
import com.projetoFinal.centralErros.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class LogDTO implements Serializable {

    private static final long serialVersionUID = 2318631367512868681L;

    private Long id;
    @NotNull
    private String title;
    @Nullable
    private String description;
    @NotNull
    private String origin;
    @Min(0)
    private Long events = 0L;
    private Boolean archieved = false;
    @Enumerated(EnumType.STRING)
    private LevelEnum levelEnum;
    @Enumerated(EnumType.STRING)
    private EnvironmentEnum environmentEnum;

    private User user;

}
