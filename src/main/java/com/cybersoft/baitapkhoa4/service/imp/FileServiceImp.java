package com.cybersoft.baitapkhoa4.service.imp;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceImp {
    Boolean saveFile(MultipartFile file);
    Resource loadFile(String filename);
}
