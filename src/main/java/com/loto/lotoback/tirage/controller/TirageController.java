package com.loto.lotoback.tirage.controller;

import com.loto.lotoback.tirage.dto.TirageDto;
import com.loto.lotoback.tirage.entity.TirageEntity;
import com.loto.lotoback.tirage.mapper.TirageMapper;
import com.loto.lotoback.tirage.service.TirageService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/tirage")
public class TirageController {

    public final TirageService service;
    public final TirageMapper mapper;

    public TirageController(TirageService service, TirageMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TirageEntity>> getTirageAll() {
        return ResponseEntity.ok(service.getTirageAll());
    }

    @PostMapping()
    public ResponseEntity<Void> saveTirage(TirageDto tirage) {
        service.saveTirage(mapper.dtoToEntity(tirage));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/list")
    public ResponseEntity<Void> saveTirage(List<TirageDto> tirages) {
        service.saveTiragesList(mapper.dtoToEntityList(tirages));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTirageById(@PathVariable("id") Integer id) {
        service.deleteTirageById(id);
        return ResponseEntity.noContent().build();
    }

}
