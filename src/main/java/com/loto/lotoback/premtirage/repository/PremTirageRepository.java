package com.loto.lotoback.premtirage.repository;

import com.loto.lotoback.premtirage.entity.PremTirageEntity;
import com.loto.lotoback.tirage.enums.NumTirageEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.loto.lotoback.tirage.enums.TypeNumEnum.PRINCIPAL;

@Repository
public interface PremTirageRepository extends JpaRepository<PremTirageEntity, Integer> {
    List<PremTirageEntity> findAllByOrderByDateTirageDesc();

    /**
     * Permet de calculer le nombre de sortie
     */
    Integer countByNum1OrNum2OrNum3OrNum4OrNum5(int num1, int num2, int num3, int num4, int num5);

    Integer countByNumComp(int numComp);

    default Integer countByNum1OrNum2OrNum3OrNum4OrNum5(int num) {
        return countByNum1OrNum2OrNum3OrNum4OrNum5(num, num, num, num, num);
    }

    default Integer countSortie(NumTirageEnum numTirageEnum) {
        return numTirageEnum.getTypeNum().equals(PRINCIPAL) ?
                countByNum1OrNum2OrNum3OrNum4OrNum5(numTirageEnum.getNumero())
                : countByNumComp(numTirageEnum.getNumero());
    }

    /**
     * Permet de calculer l'écart
     */
    PremTirageEntity findFirstByNum1OrNum2OrNum3OrNum4OrNum5OrderByDateTirageDesc(int num1, int num2, int num3, int num4, int num5);

    PremTirageEntity findFirstByNumCompOrderByDateTirageDesc(int numComp);

    default PremTirageEntity findFirstByNum1OrNum2OrNum3OrNum4OrNum5OrderByDateTirageDesc(int num) {
        return findFirstByNum1OrNum2OrNum3OrNum4OrNum5OrderByDateTirageDesc(num, num, num, num, num);
    }

    default PremTirageEntity findFirstByNum(NumTirageEnum numTirageEnum) {
        return numTirageEnum.getTypeNum().equals(PRINCIPAL) ?
                findFirstByNum1OrNum2OrNum3OrNum4OrNum5OrderByDateTirageDesc(numTirageEnum.getNumero())
                : findFirstByNumCompOrderByDateTirageDesc(numTirageEnum.getNumero());
    }

    Integer countByDateTirageGreaterThan(LocalDate localDate);

    default Integer countEcart(NumTirageEnum numTirageEnum) {
        return countByDateTirageGreaterThan(findFirstByNum(numTirageEnum).getDateTirage());
    }

}
