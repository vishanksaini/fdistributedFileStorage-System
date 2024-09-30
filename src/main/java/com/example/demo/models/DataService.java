package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter

@Entity
@Table(name = "data_service")
public class DataService {

@Id
    private Long dataServiceId;
    private String storagePath;
    private String storageType;
    @OneToMany(mappedBy = "dataService",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Metadata> files;

}
