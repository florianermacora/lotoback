package com.loto.lotoback.premtirage.service;

import com.loto.lotoback.premtirage.entity.PremTirageEntity;
import com.loto.lotoback.premtirage.repository.PremTirageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PremTirageService {

    public final PremTirageRepository repository;

    public PremTirageService(PremTirageRepository repository) {
        this.repository = repository;
    }

    public List<PremTirageEntity> getTirageAll() {
        return repository.findAllByOrderByDateTirageDesc();
    }

    public void saveTirage(PremTirageEntity premTirageEntity) {
        repository.save(premTirageEntity);
    }

    public void saveTiragesList(List<PremTirageEntity> tirageEntities) {
        repository.saveAll(tirageEntities);
    }

    public void deleteTirageById(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
    }

}
