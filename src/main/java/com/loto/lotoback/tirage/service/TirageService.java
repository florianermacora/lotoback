package com.loto.lotoback.tirage.service;

import com.loto.lotoback.tirage.entity.TirageEntity;
import com.loto.lotoback.tirage.mapper.TirageMapper;
import com.loto.lotoback.tirage.repository.TirageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TirageService {

    public final TirageRepository repository;

    public TirageService(TirageRepository repository) {
        this.repository = repository;
    }

    public List<TirageEntity> getTirageAll() {
        return repository.findAllByOrderByDateTirageDesc();
    }

    public void saveTirage(TirageEntity tirageEntity) {
        repository.save(tirageEntity);
    }

    public void saveTiragesList(List<TirageEntity> tirageEntities) {
        repository.saveAll(tirageEntities);
    }

    public void deleteTirageById(Integer id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
    }

}
