package com.loto.lotoback.statisque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "statistique_prem")
public class PremStatEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "numero")
    private int numero;

    @Column(name = "principal")
    private boolean principal;

    @Column(name = "nb_sortie")
    private int nbSortie;

    @Column(name = "annonce")
    private int annonce;

    @Column(name = "ecart")
    private int ecart;

    @Column(name = "date_tirage")
    private LocalDate dateTirage;

}
