package com.loto.lotoback.statisque.repository;

import com.loto.lotoback.statisque.entity.PremStatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PremStatRepository extends JpaRepository<PremStatEntity, Integer> {

    @Modifying
    @Transactional
    @Query("update PremStatEntity stat " +
            "set stat.nbSortie = ?1, stat.annonce = ?2, stat.ecart = ?3, stat.dateTirage = ?4 " +
            "where stat.numero = ?5 and stat.principal = ?6")
    void updateStat(Integer nbTirage, Integer annonce, Integer ecart, LocalDate dateSortie, Integer numero, Boolean principal);

    @Modifying
    @Transactional
    @Query("update PremStatEntity stat " +
            "set stat.annonce = stat.annonce+1 " +
            "where stat.numero in ?1 and stat.principal = true")
    void updateAnonceNumeroPrincipal(List<Integer> listNumRessorti);

    @Modifying
    @Transactional
    @Query("update PremStatEntity stat " +
            "set stat.annonce = stat.annonce+1 " +
            "where stat.numero = ?1 and stat.principal = false")
    void updateAnonceNumComp(Integer num);

}
