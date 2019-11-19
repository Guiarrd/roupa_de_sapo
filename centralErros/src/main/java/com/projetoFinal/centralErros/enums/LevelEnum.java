package com.projetoFinal.centralErros.enums;

public enum LevelEnum {
    ERROR("ERRO"),
    WARNING("AVISO"),
    DEBUG("DEPURAÇÂO");

    private String type;

    LevelEnum(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}
