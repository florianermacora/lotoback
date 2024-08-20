package com.loto.lotoback.tirage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TirageDto {

    private Integer id;
    private Integer num1;
    private Integer num2;
    private Integer num3;
    private Integer num4;
    private Integer num5;
    private Integer numComp;
    private LocalDate dateTirage;

}
