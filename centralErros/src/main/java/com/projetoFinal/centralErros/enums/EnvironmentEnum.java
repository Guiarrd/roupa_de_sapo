package com.projetoFinal.centralErros.enums;

public enum EnvironmentEnum {
    PRODUCTION("PRODUÇÃO"),
    TEST("HOMOLOGAÇÃO"),
    DEVELOPMENT("DESENVOLVIMENTO");

    private String type;

    EnvironmentEnum(String type) {
        this.type = type;
    }

    public String type() {
       return type;
    }
}
