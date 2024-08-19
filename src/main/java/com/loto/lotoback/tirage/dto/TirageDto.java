package com.loto.lotoback.tirage.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.io.Serializable;
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
    private LocalDate dateTirage;

    public TirageDto(Integer num1, Integer num2, Integer num3, Integer num4, Integer num5, LocalDate dateTirage) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.dateTirage = dateTirage;
    }

}
