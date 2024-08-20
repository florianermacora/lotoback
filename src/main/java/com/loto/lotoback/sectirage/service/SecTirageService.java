package com.loto.lotoback.sectirage.service;

import com.loto.lotoback.sectirage.entity.SecTirageEntity;
import com.loto.lotoback.sectirage.repository.SecTirageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SecTirageService {

    public final SecTirageRepository repository;

    public SecTirageService(SecTirageRepository repository) {
        this.repository = repository;
    }

    public List<SecTirageEntity> getTirageAll() {
        return repository.findAllByOrderByDateTirageDesc();
    }

    public void saveTirage(SecTirageEntity premTirageEntity) {
        repository.save(premTirageEntity);
    }

    public void saveTiragesList(List<SecTirageEntity> tirageEntities) {
        repository.saveAll(tirageEntities);
    }

    public void deleteTirageById(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
    }
}
