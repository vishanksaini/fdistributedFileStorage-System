package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "metadata")
public class Metadata {

    @Id
    private Long fileId;
    private String filePath;
    private String fileName;
    private Long filesize;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="data_service_id",nullable = false)
    private DataService dataService;


}
