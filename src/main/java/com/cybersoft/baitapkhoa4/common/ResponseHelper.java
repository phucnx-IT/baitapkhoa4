package com.cybersoft.baitapkhoa4.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ResponseHelper {
    public static ResponseEntity<?> getResponse(Object object, HttpStatus httpStatus){
        Map<String, Object> map = new HashMap<>();
        map.put("hasErros",false);
        map.put("content",object);
        map.put("error", "");
        map.put("timeStamp", LocalDateTime.now());
        map.put("status", httpStatus);
        return new ResponseEntity<>(map,httpStatus);
    }

    public static ResponseEntity<?> getResponse(String message, HttpStatus httpStatus){
        Map<String, Object> map = new HashMap<>();
        map.put("hasErros",false);
        map.put("content",message);
        map.put("error", "");
        map.put("timeStamp", LocalDateTime.now());
        map.put("status", httpStatus);
        return new ResponseEntity<>(map,httpStatus);
    }
}
