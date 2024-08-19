package com.loto.lotoback.file.controller;

import com.loto.lotoback.file.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    public final FileService service;

    public FileController(FileService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadLotoFile(@RequestParam("file") MultipartFile file) {
        if (!service.hasCsvFormat(file)) {
            return ResponseEntity.badRequest().body("Le fichier n'est pas un csv");
        }
        service.processAndSaveData(file);
        return ResponseEntity.ok().build();
    }
}
