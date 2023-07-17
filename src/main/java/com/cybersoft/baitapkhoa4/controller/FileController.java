package com.cybersoft.baitapkhoa4.controller;

import com.cybersoft.baitapkhoa4.common.ResponseHelper;
import com.cybersoft.baitapkhoa4.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileServiceImp fileServiceImp;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file){
        if (fileServiceImp.saveFile(file)) {
            return ResponseHelper.getResponse("File created", HttpStatus.CREATED);
        }
        return ResponseHelper.getResponse("Cannot upload file", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getfile/{fileName:.*}")
    public ResponseEntity<?> getFile(@PathVariable String fileName){
        Resource resource = fileServiceImp.loadFile(fileName);
        return new ResponseEntity<>(resource,HttpStatus.OK);
    }
}
