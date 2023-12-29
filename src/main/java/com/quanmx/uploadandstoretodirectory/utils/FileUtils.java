package com.quanmx.uploadandstoretodirectory.utils;

import com.quanmx.uploadandstoretodirectory.exception.NotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.MalformedURLException;

@Component
public class FileUtils {
    public Resource getFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new NotFoundException("Could not find out any file");
        }
        Resource resource = null;
        try {
            resource = new UrlResource(file.toURI());
        } catch (MalformedURLException e) {
            throw new NotFoundException("Could not find out any file");
        }
        return resource;
    }
}
