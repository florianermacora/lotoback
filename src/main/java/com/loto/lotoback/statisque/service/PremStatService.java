package com.loto.lotoback.statisque.service;

import com.loto.lotoback.premtirage.entity.PremTirageEntity;
import com.loto.lotoback.premtirage.repository.PremTirageRepository;
import com.loto.lotoback.statisque.repository.PremStatRepository;
import com.loto.lotoback.tirage.enums.NumTirageEnum;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;

import static com.loto.lotoback.statisque.utils.StatNumUtils.getNumAnnonce;
import static com.loto.lotoback.statisque.utils.StatNumUtils.tirageToList;
import static com.loto.lotoback.tirage.enums.TypeNumEnum.isPrincipal;

@Service
public class PremStatService {

    public final PremTirageRepository premTirageRepository;
    public final PremStatRepository premStatRepository;

    public PremStatService(PremTirageRepository premTirageRepository, PremStatRepository premStatRepository) {
        this.premTirageRepository = premTirageRepository;
        this.premStatRepository = premStatRepository;
    }

    public void init() {
        for (NumTirageEnum numTirageEnum : NumTirageEnum.values()) {
            PremTirageEntity tirage = this.premTirageRepository.findFirstByNum(numTirageEnum);
            this.initStat(
                    this.countSortie(numTirageEnum), this.countEcart(numTirageEnum),
                    tirage.getDateTirage(), numTirageEnum);
        }

        this.countAnnonce();
    }

    private void countAnnonce() {
        List<PremTirageEntity> tirageList = this.premTirageRepository.findAllByOrderByDateTirageDesc();

        for (int i = 0; i < tirageList.size()-1; i++) {
            List<Integer> listTirageActuelle = tirageToList(tirageList.get(i));
            List<Integer> listTiragePrecedent = tirageToList(tirageList.get(i + 1));
            List<Integer> listNumAnnonce = getNumAnnonce(listTiragePrecedent, listTirageActuelle);

            if (!CollectionUtils.isEmpty(listNumAnnonce)) {
                this.updateAnnonceNumPrincipal(listNumAnnonce);
            }

            if (!tirageList.get(i).getNumComp().equals(tirageList.get(i + 1).getNumComp())) {
                this.updateAnnonceNumComp(tirageList.get(i).getNumComp());
            }
        }
    }

    private void updateAnnonceNumComp(Integer numComp) {
        this.premStatRepository.updateAnonceNumComp(numComp);
    }

    private void updateAnnonceNumPrincipal(List<Integer> listNumRessorti) {
        this.premStatRepository.updateAnonceNumeroPrincipal(listNumRessorti);
    }

    private Integer countSortie(NumTirageEnum numTirageEnum) {
        return this.premTirageRepository.countSortie(numTirageEnum);
    }

    private Integer countEcart(NumTirageEnum numTirageEnum) {
        return this.premTirageRepository.countEcart(numTirageEnum);
    }

    private void initStat(Integer nbTirage, Integer ecart, LocalDate dateSortie, NumTirageEnum numTirageEnum) {
        this.premStatRepository.updateStat(nbTirage, 0, ecart, dateSortie, numTirageEnum.getNumero(), isPrincipal(numTirageEnum.getTypeNum()));
    }

}
