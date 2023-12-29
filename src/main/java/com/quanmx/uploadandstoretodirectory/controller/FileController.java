package com.quanmx.uploadandstoretodirectory.controller;

import com.quanmx.uploadandstoretodirectory.model.FileInfor;
import com.quanmx.uploadandstoretodirectory.service.IFileInfoService;
import com.quanmx.uploadandstoretodirectory.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {

    private IFileInfoService fileInfoService;
    private FileUtils fileUtils;

    @Autowired
    public FileController(IFileInfoService fileInfoService, FileUtils fileUtils) {
        this.fileInfoService = fileInfoService;
        this.fileUtils = fileUtils;
    }

    @PostMapping
    public ResponseEntity<FileInfor> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        return ResponseEntity.ok(fileInfoService.saveFile(multipartFile));
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadFile(@PathVariable("fileName") String fileName) {
        FileInfor fileInfor = fileInfoService.getFileByName(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(fileInfor.getType()))
                .body(fileUtils.getFile(fileInfor.getPath()));
    }
}
