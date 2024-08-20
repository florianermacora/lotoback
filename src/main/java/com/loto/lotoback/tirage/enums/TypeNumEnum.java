package com.loto.lotoback.tirage.enums;

public enum TypeNumEnum {
    PRINCIPAL,
    COMPLEMENTAIRE;

    public static Boolean isPrincipal(TypeNumEnum typeNumEnum) {
        return typeNumEnum.equals(PRINCIPAL);
    }

}
