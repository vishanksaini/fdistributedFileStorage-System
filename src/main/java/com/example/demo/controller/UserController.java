package com.example.demo.controller;
import com.example.demo.config.FileStorageProperties;
import com.example.demo.services.Fileservice;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    //user makes request to get a file

    @Autowired
    Fileservice fileservice;



    @GetMapping("file/{fileId}")
    public ResponseEntity<Resource> getFile(@PathVariable Long fileId) {

        Resource fileResource=fileservice.getFileByFileId(fileId);
        if(fileResource.exists())
        {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+fileResource.getFilename()+"\"").body(fileResource);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }






}
