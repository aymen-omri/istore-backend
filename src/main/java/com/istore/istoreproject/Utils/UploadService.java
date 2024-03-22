package com.istore.istoreproject.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

    public String saveFile(MultipartFile file) throws IOException {
        String fileName = generateRandomString() + "_" + file.getOriginalFilename();
        String filePath = "src/main/resources/uploads/" + fileName;

        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

        return "http://localhost:8080/content/" + fileName;
    }

    private String generateRandomString() {
        return UUID.randomUUID().toString().substring(0, 20);
    }

}
