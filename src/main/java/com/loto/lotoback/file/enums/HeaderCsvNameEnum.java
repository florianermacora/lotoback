package com.loto.lotoback.file.enums;

import lombok.Getter;

@Getter
public enum HeaderCsvNameEnum {
    BOULE1("boule_1"),
    BOULE2("boule_2"),
    BOULE3("boule_3"),
    BOULE4("boule_4"),
    BOULE5("boule_5"),
    BOULECOMP("numero_chance"),
    BOULE1_2("boule_1_second_tirage"),
    BOULE2_2("boule_2_second_tirage"),
    BOULE3_2("boule_3_second_tirage"),
    BOULE4_2("boule_4_second_tirage"),
    BOULE5_2("boule_5_second_tirage"),
    DATE_TIRAGE("date_de_tirage");

    private final String nameBoule;

    HeaderCsvNameEnum(String nameBoule) {
        this.nameBoule = nameBoule;
    }

}
