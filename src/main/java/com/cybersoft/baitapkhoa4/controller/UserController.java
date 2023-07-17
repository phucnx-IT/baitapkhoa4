package com.cybersoft.baitapkhoa4.controller;

import com.cybersoft.baitapkhoa4.common.ResponseHelper;
import com.cybersoft.baitapkhoa4.dto.UserDto;
import com.cybersoft.baitapkhoa4.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @PostMapping("/createuser")
    public ResponseEntity<?> createNewUser(@RequestBody UserDto userDto){
        userServiceImp.createNewUser(userDto);
        return ResponseHelper.getResponse("Created a new user", HttpStatus.CREATED);
    }
}
