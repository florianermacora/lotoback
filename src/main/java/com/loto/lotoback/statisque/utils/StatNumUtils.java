package com.loto.lotoback.statisque.utils;

import com.loto.lotoback.premtirage.entity.PremTirageEntity;
import com.loto.lotoback.sectirage.entity.SecTirageEntity;

import java.util.ArrayList;
import java.util.List;

public final class StatNumUtils {

    public static List<Integer> getNumAnnonce(List<Integer> listTiragePrecedent, List<Integer> listTirageActuelle) {
        List<Integer> numAnnonce = new ArrayList<>();

        for (Integer numero : listTiragePrecedent) {
            if (!listTirageActuelle.contains(numero)) {
                numAnnonce.add(numero);
            }
        }

        return numAnnonce;
    }

    public static List<Integer> tirageToList(PremTirageEntity tirageEntity) {
        List<Integer> list = new ArrayList<>();
        list.add(tirageEntity.getNum1());
        list.add(tirageEntity.getNum2());
        list.add(tirageEntity.getNum3());
        list.add(tirageEntity.getNum4());
        list.add(tirageEntity.getNum5());
        return list;
    }

    public static List<Integer> tirageToList(SecTirageEntity tirageEntity) {
        List<Integer> list = new ArrayList<>();
        list.add(tirageEntity.getNum1());
        list.add(tirageEntity.getNum2());
        list.add(tirageEntity.getNum3());
        list.add(tirageEntity.getNum4());
        list.add(tirageEntity.getNum5());
        return list;
    }

}
