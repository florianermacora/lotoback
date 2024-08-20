package com.loto.lotoback.statisque.controller;

import com.loto.lotoback.statisque.service.PremStatService;
import com.loto.lotoback.statisque.service.SecStatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistique")
public class StatisqueContoller {

    public final PremStatService premStatService;
    public final SecStatService secStatService;

    public StatisqueContoller(PremStatService premStatService, SecStatService secStatService) {
        this.premStatService = premStatService;
        this.secStatService = secStatService;
    }


    @PutMapping("/init")
    public ResponseEntity<Void> initStatistique() {

        premStatService.init();
        secStatService.init();

        return ResponseEntity.ok().build();

    }

}
