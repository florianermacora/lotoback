package com.loto.lotoback.tirage.controller;

import com.loto.lotoback.premtirage.mapper.PremTirageMapper;
import com.loto.lotoback.premtirage.service.PremTirageService;
import com.loto.lotoback.sectirage.mapper.SecTirageMapper;
import com.loto.lotoback.sectirage.service.SecTirageService;
import com.loto.lotoback.tirage.dto.SaveTirage;
import com.loto.lotoback.tirage.dto.SaveTirageList;
import com.loto.lotoback.tirage.dto.TirageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tirage")
public class TirageController {

    public final PremTirageService premTirageService;
    public final PremTirageMapper premTirageMapper;
    public final SecTirageService secTirageService;
    public final SecTirageMapper secTirageMapper;

    public TirageController(PremTirageService premTirageService, PremTirageMapper premTirageMapper,
                            SecTirageService secTirageService, SecTirageMapper secTirageMapper) {
        this.premTirageService = premTirageService;
        this.premTirageMapper = premTirageMapper;
        this.secTirageService = secTirageService;
        this.secTirageMapper = secTirageMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TirageDto>> getTirageAll(@RequestParam(name = "isFirst") Boolean isFirst) {
        List<TirageDto> tirageList = new ArrayList<>();
        if (isFirst) {
            tirageList = this.premTirageMapper.entityToDtoList(premTirageService.getTirageAll());
        } else {
            tirageList = this.secTirageMapper.entityToDtoList(secTirageService.getTirageAll());
        }
        return ResponseEntity.ok(tirageList);
    }

    @PostMapping()
    public ResponseEntity<Void> saveTirage(SaveTirage saveTirage) {
        if (saveTirage.getIsFirst()) {
            premTirageService.saveTirage(premTirageMapper.dtoToEntity(saveTirage.getTirageList()));
        } else {
            secTirageService.saveTirage(secTirageMapper.dtoToEntity(saveTirage.getTirageList()));
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/list")
    public ResponseEntity<Void> saveTirage(SaveTirageList saveTirageList) {
        if (saveTirageList.getIsFirst()) {
            premTirageService.saveTiragesList(premTirageMapper.dtoToEntityList(saveTirageList.getTirageList()));
        } else {
            secTirageService.saveTiragesList(secTirageMapper.dtoToEntityList(saveTirageList.getTirageList()));
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/id/{id}/idFirst/{isFirst}")
    public ResponseEntity<Void> deleteTirageById(@PathVariable("id") Integer id, @PathVariable("isFirst") Boolean isFirst) {
        if (isFirst) {
            premTirageService.deleteTirageById(id);
        } else {
            secTirageService.deleteTirageById(id);
        }
        return ResponseEntity.noContent().build();
    }

}
