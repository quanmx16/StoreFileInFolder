package com.quanmx.uploadandstoretodirectory.repository;

import com.quanmx.uploadandstoretodirectory.model.FileInfor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileInfoRepository extends JpaRepository<FileInfor, String> {
    public Optional<FileInfor> findById(String id);

    public FileInfor save(FileInfor fileInfor);

    public Optional<FileInfor> findByName(String name);
}
