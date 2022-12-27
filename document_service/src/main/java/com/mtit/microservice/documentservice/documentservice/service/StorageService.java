package com.mtit.microservice.documentservice.documentservice.service;

import com.mtit.microservice.documentservice.documentservice.entity.FileData;
import com.mtit.microservice.documentservice.documentservice.repository.StorageRepository;
import com.mtit.microservice.documentservice.documentservice.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    public String uploadfile(MultipartFile file) throws IOException {
        FileData fileData = repository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .data(FileUtils.compressImage(file.getBytes()))
                .build());
        if(fileData != null){
            return "File Uploaded Successfully";
        }

        return "File Upload Failed";

}

    public byte[] downloadFile(String name) throws IOException {
        FileData fileData = repository.findByName(name).get();
        return FileUtils.decompressImage(fileData.getData());
    }
}
