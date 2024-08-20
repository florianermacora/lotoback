package com.loto.lotoback.statisque.repository;

import com.loto.lotoback.statisque.entity.SecStatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface SecStatRepository extends JpaRepository<SecStatEntity, Integer> {

    @Modifying
    @Transactional
    @Query("update SecStatEntity stat " +
            "set stat.nbSortie = ?1, stat.annonce = ?2, stat.ecart = ?3, stat.dateTirage = ?4 " +
            "where stat.numero = ?5")
    void updateStat(Integer nbTirage, Integer annonce, Integer ecart, LocalDate dateSortie, Integer numero);

    @Modifying
    @Transactional
    @Query("update SecStatEntity stat " +
            "set stat.annonce = stat.annonce+1 " +
            "where stat.numero in ?1")
    void updateAnonceNumeroPrincipal(List<Integer> listNumRessorti);

}
