package com.cybersoft.baitapkhoa4.service;

import com.cybersoft.baitapkhoa4.service.imp.FileServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService implements FileServiceImp {
    private final String rootPath = "D:\\uploads";
    private final Logger logger = LoggerFactory.getLogger(FileService.class);
    private Path root;
    private void init(){
        try{
            root = Paths.get(rootPath);
            if (Files.notExists(root)){
                Files.createDirectories(root);
            }
        }catch (Exception e){
            logger.warn(e.getMessage());
        }
    }
    @Override
    public Boolean saveFile(MultipartFile file) {
        init();
        try{
            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            return true;
        }catch (Exception e){
            logger.warn(e.getMessage());
        }
        return false;
    }

    @Override
    public Resource loadFile(String filename) {
        init();
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() && resource.isReadable()) {
                return resource;
            }
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        return null;
    }
}
