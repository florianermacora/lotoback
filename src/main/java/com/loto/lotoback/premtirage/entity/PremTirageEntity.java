package com.loto.lotoback.premtirage.entity;

import com.loto.lotoback.sectirage.entity.SecTirageEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tirage_prem")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PremTirageEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "num1")
    private Integer num1;

    @Column(name = "num2")
    private Integer num2;

    @Column(name = "num3")
    private Integer num3;

    @Column(name = "num4")
    private Integer num4;

    @Column(name = "num5")
    private Integer num5;

    @Column(name = "date_tirage")
    private LocalDate dateTirage;

    @Column(name = "num_comp")
    private Integer numComp;

    public PremTirageEntity(Integer num1, Integer num2, Integer num3, Integer num4, Integer num5, Integer numComp, LocalDate dateTirage) {
        this.setNum1(num1);
        this.setNum2(num2);
        this.setNum3(num3);
        this.setNum4(num4);
        this.setNum5(num5);
        this.numComp = numComp;
        this.setDateTirage(dateTirage);
    }

}
