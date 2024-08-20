package com.loto.lotoback.statisque.service;

import com.loto.lotoback.sectirage.entity.SecTirageEntity;
import com.loto.lotoback.sectirage.repository.SecTirageRepository;
import com.loto.lotoback.statisque.repository.SecStatRepository;
import com.loto.lotoback.tirage.enums.NumTirageEnum;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;

import static com.loto.lotoback.statisque.utils.StatNumUtils.getNumAnnonce;
import static com.loto.lotoback.statisque.utils.StatNumUtils.tirageToList;
import static com.loto.lotoback.tirage.enums.TypeNumEnum.isPrincipal;

@Service
public class SecStatService {
    public final SecTirageRepository secTirageRepository;
    public final SecStatRepository secStatRepository;

    public SecStatService(SecTirageRepository secTirageRepository, SecStatRepository secStatRepository) {
        this.secTirageRepository = secTirageRepository;
        this.secStatRepository = secStatRepository;
    }

    public void init() {
        for (NumTirageEnum numTirageEnum : NumTirageEnum.values()) {
            if (isPrincipal(numTirageEnum.getTypeNum())) {
                SecTirageEntity tirage = this.secTirageRepository.findFirstByNum(numTirageEnum);
                this.initStat(
                        this.countSortie(numTirageEnum), this.countEcart(numTirageEnum),
                        tirage.getDateTirage(), numTirageEnum);
            }
        }

        this.countAnnonce();
    }

    private void countAnnonce() {
        List<SecTirageEntity> tirageList = this.secTirageRepository.findAllByOrderByDateTirageDesc();

        for (int i = 0; i < tirageList.size()-1; i++) {
            List<Integer> listTirageActuelle = tirageToList(tirageList.get(i));
            List<Integer> listTiragePrecedent = tirageToList(tirageList.get(i + 1));
            List<Integer> listNumAnnonce = getNumAnnonce(listTiragePrecedent, listTirageActuelle);

            if (!CollectionUtils.isEmpty(listNumAnnonce)) {
                this.updateAnnonceNumPrincipal(listNumAnnonce);
            }
        }
    }

    private void updateAnnonceNumPrincipal(List<Integer> listNumRessorti) {
        this.secStatRepository.updateAnonceNumeroPrincipal(listNumRessorti);
    }

    private Integer countSortie(NumTirageEnum numTirageEnum) {
        return this.secTirageRepository.countSortie(numTirageEnum);
    }

    private Integer countEcart(NumTirageEnum numTirageEnum) {
        return this.secTirageRepository.countEcart(numTirageEnum);
    }

    private void initStat(Integer nbTirage, Integer ecart, LocalDate dateSortie, NumTirageEnum numTirageEnum) {
        this.secStatRepository.updateStat(nbTirage, 0, ecart, dateSortie, numTirageEnum.getNumero());
    }

}
