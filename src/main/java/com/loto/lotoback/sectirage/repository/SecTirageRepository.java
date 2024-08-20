package com.loto.lotoback.sectirage.repository;

import com.loto.lotoback.sectirage.entity.SecTirageEntity;
import com.loto.lotoback.tirage.enums.NumTirageEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SecTirageRepository extends JpaRepository<SecTirageEntity, Integer> {
    List<SecTirageEntity> findAllByOrderByDateTirageDesc();

    /**
     * Permet de calculer le nombre de sortie
     */
    Integer countByNum1OrNum2OrNum3OrNum4OrNum5(int num1, int num2, int num3, int num4, int num5);

    default Integer countByNum1OrNum2OrNum3OrNum4OrNum5(int num) {
        return countByNum1OrNum2OrNum3OrNum4OrNum5(num, num, num, num, num);
    }

    default Integer countSortie(NumTirageEnum numTirageEnum) {
        return countByNum1OrNum2OrNum3OrNum4OrNum5(numTirageEnum.getNumero());
    }

    /**
     * Permet de calculer l'écart
     */
    SecTirageEntity findFirstByNum1OrNum2OrNum3OrNum4OrNum5OrderByDateTirageDesc(int num1, int num2, int num3, int num4, int num5);

    default SecTirageEntity findFirstByNum1OrNum2OrNum3OrNum4OrNum5OrderByDateTirageDesc(int num) {
        return findFirstByNum1OrNum2OrNum3OrNum4OrNum5OrderByDateTirageDesc(num, num, num, num, num);
    }

    default SecTirageEntity findFirstByNum(NumTirageEnum numTirageEnum) {
        return findFirstByNum1OrNum2OrNum3OrNum4OrNum5OrderByDateTirageDesc(numTirageEnum.getNumero());
    }

    Integer countByDateTirageGreaterThan(LocalDate localDate);

    default Integer countEcart(NumTirageEnum numTirageEnum) {
        return countByDateTirageGreaterThan(findFirstByNum(numTirageEnum).getDateTirage());
    }

}
