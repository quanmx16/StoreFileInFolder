package com.quanmx.uploadandstoretodirectory.service;

import com.quanmx.uploadandstoretodirectory.model.FileInfor;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileInfoService {
    public FileInfor saveFile(MultipartFile multipartFile) throws IOException;

    public FileInfor getFileByName(String name);

    public FileInfor getFileById(String id);
}
