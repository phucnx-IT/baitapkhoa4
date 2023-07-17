package com.cybersoft.baitapkhoa4.controller;

import com.cybersoft.baitapkhoa4.common.ResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homepage")
public class HomePageController {

    @GetMapping
    public ResponseEntity<?> getHomePage(){
        return ResponseHelper.getResponse("This is homepage", HttpStatus.OK);
    }
}
