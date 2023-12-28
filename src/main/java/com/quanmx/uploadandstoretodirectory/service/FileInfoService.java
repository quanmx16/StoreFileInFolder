package com.quanmx.uploadandstoretodirectory.service;

import com.quanmx.uploadandstoretodirectory.exception.NotFoundException;
import com.quanmx.uploadandstoretodirectory.model.FileInfor;
import com.quanmx.uploadandstoretodirectory.repository.FileInfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FileInfoService implements IFileInfoService {
    private FileInfoRepository fileInfoRepository;
    @Value("${server.file-path}")
    private String filePath;

    @Autowired
    public FileInfoService(FileInfoRepository fileInfoRepository) {
        this.fileInfoRepository = fileInfoRepository;
    }

    @Override
    @Transactional
    public FileInfor saveFile(MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmssSSS")) + fileName;
        multipartFile.transferTo(new File(filePath + File.separator + fileName));

        FileInfor fileInfor = FileInfor.builder()
                .path(filePath + File.separator + fileName)
                .name(fileName)
                .type(multipartFile.getContentType())
                .build();
        return fileInfoRepository.save(fileInfor);
    }

    @Override
    public FileInfor getFileByName(String name) {
        FileInfor fileInfor = fileInfoRepository.findByName(name).orElse(null);
        if (fileInfor == null) {
            throw new NotFoundException("Could not find out any file");
        }
        return fileInfor;
    }

    @Override
    public FileInfor getFileById(String id) {
        FileInfor fileInfor = fileInfoRepository.findByName(id).orElse(null);
        if (fileInfor == null) {
            throw new NotFoundException("Could not find out any file");
        }
        return fileInfor;
    }
}
