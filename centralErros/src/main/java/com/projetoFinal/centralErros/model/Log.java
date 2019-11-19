package com.projetoFinal.centralErros.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoFinal.centralErros.enums.EnvironmentEnum;
import com.projetoFinal.centralErros.enums.LevelEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Log implements Serializable {

    private static final long serialVersionUID = -7100994741092022256L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(max = 100)
    private String title;

    @Column
    @Nullable
    @Size(max = 250)
    private String description;

    @Column
    @NotNull
    @Size(max = 30)
    private String origin;

    @Column
    @Min(0)
    private Long events = 0L;

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDate createdAt;

    @Column
    private Boolean archived = false;

    @Enumerated(EnumType.STRING)
    private LevelEnum levelEnum;

    @Enumerated(EnumType.STRING)
    private EnvironmentEnum environmentEnum;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}
