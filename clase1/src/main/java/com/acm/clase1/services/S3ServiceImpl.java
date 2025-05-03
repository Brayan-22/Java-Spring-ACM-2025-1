package com.acm.clase1.services;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


@Service
public class S3ServiceImpl implements IS3Service{

    @Override
    public void uploadFile(String fileName, String filePath) {
        System.out.println("Uploading file " + fileName + " to " + filePath);
    }

    @Override
    public String downloadFile(String fileName) {
        return "Downloading file " + fileName;
    }
}
