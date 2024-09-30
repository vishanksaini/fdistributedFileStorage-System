package com.example.demo.services;

import com.example.demo.config.FileStorageProperties;
import com.example.demo.models.Metadata;
import com.example.demo.repositories.MetadataRepository;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class Fileservice {

    @Autowired
    private MetadataRepository metadataRepository;

    @Autowired
    private FileStorageProperties fileStorageProperties;

    //get file from repository;

    public Resource getFileByFileId(Long FileId){
        Optional<Metadata> metadataOptional = metadataRepository.findByFileId(FileId);

        if(metadataOptional.isPresent())
        {
            Metadata metadata = metadataOptional.get();

            Path filePath= Paths.get(metadata.getFilePath());

            try{
                //convert a filepath to Resource
                Resource resource = new UrlResource(filePath.toUri());

                if(resource.exists() || resource.isReadable())
                    return resource;
                else
                    System.out.println("Could not read the file: " + filePath);;
            }catch (Exception e)
            {
                System.out.println("Could not read the file: " + filePath);;
            }
        }
        return null;


    }
}
