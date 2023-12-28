package com.quanmx.uploadandstoretodirectory.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "file_infors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileInfor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String type;
    private String path;
    private String name;
}
