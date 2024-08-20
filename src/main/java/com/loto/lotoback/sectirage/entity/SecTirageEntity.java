package com.loto.lotoback.sectirage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tirage_sec")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SecTirageEntity {

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

    public SecTirageEntity(Integer num1, Integer num2, Integer num3, Integer num4, Integer num5, LocalDate dateTirage) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.dateTirage = dateTirage;
    }

}
