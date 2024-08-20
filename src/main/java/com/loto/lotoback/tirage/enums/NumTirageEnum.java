package com.loto.lotoback.tirage.enums;

import lombok.Getter;

import static com.loto.lotoback.tirage.enums.TypeNumEnum.COMPLEMENTAIRE;
import static com.loto.lotoback.tirage.enums.TypeNumEnum.PRINCIPAL;

@Getter
public enum NumTirageEnum {

    P1(1, PRINCIPAL),
    P2(2, PRINCIPAL),
    P3(3, PRINCIPAL),
    P4(4, PRINCIPAL),
    P5(5, PRINCIPAL),
    P6(6, PRINCIPAL),
    P7(7, PRINCIPAL),
    P8(8, PRINCIPAL),
    P9(9, PRINCIPAL),
    P10(10, PRINCIPAL),
    P11(11, PRINCIPAL),
    P12(12, PRINCIPAL),
    P13(13, PRINCIPAL),
    P14(14, PRINCIPAL),
    P15(15, PRINCIPAL),
    P16(16, PRINCIPAL),
    P17(17, PRINCIPAL),
    P18(18, PRINCIPAL),
    P19(19, PRINCIPAL),
    P20(20, PRINCIPAL),
    P21(21, PRINCIPAL),
    P22(22, PRINCIPAL),
    P23(23, PRINCIPAL),
    P24(24, PRINCIPAL),
    P25(25, PRINCIPAL),
    P26(26, PRINCIPAL),
    P27(27, PRINCIPAL),
    P28(28, PRINCIPAL),
    P29(29, PRINCIPAL),
    P30(30, PRINCIPAL),
    P31(31, PRINCIPAL),
    P32(32, PRINCIPAL),
    P33(33, PRINCIPAL),
    P34(34, PRINCIPAL),
    P35(35, PRINCIPAL),
    P36(36, PRINCIPAL),
    P37(37, PRINCIPAL),
    P38(38, PRINCIPAL),
    P39(39, PRINCIPAL),
    P40(40, PRINCIPAL),
    P41(41, PRINCIPAL),
    P42(42, PRINCIPAL),
    P43(43, PRINCIPAL),
    P44(44, PRINCIPAL),
    P45(45, PRINCIPAL),
    P46(46, PRINCIPAL),
    P47(47, PRINCIPAL),
    P48(48, PRINCIPAL),
    P49(49, PRINCIPAL),
    C1(1, COMPLEMENTAIRE),
    C2(2, COMPLEMENTAIRE),
    C3(3, COMPLEMENTAIRE),
    C4(4, COMPLEMENTAIRE),
    C5(5, COMPLEMENTAIRE),
    C6(6, COMPLEMENTAIRE),
    C7(7, COMPLEMENTAIRE),
    C8(8, COMPLEMENTAIRE),
    C9(9, COMPLEMENTAIRE),
    C10(10, COMPLEMENTAIRE);

    private int numero;
    private TypeNumEnum typeNum;

    NumTirageEnum(int numero, TypeNumEnum typeNum) {
        this.numero = numero;
        this.typeNum = typeNum;
    }


}
