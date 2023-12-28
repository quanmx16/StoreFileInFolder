package com.quanmx.uploadandstoretodirectory.controller;

import com.quanmx.uploadandstoretodirectory.model.FileInfor;
import com.quanmx.uploadandstoretodirectory.service.IFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {

    private IFileInfoService fileInfoService;

    @Autowired
    public FileController(IFileInfoService fileInfoService) {
        this.fileInfoService = fileInfoService;
    }

    @PostMapping
    public ResponseEntity<FileInfor> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        return ResponseEntity.ok(fileInfoService.saveFile(multipartFile));
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadFile(@PathVariable("fileName") String fileName) {
        return null;
    }
}
