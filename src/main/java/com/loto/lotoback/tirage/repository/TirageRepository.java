package com.loto.lotoback.tirage.repository;

import com.loto.lotoback.tirage.entity.TirageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TirageRepository extends JpaRepository<TirageEntity, Integer> {
    List<TirageEntity> findAllByOrderByDateTirageDesc();
}
