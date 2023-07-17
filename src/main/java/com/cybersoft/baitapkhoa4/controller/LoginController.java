package com.cybersoft.baitapkhoa4.controller;

import com.cybersoft.baitapkhoa4.common.ResponseHelper;
import com.cybersoft.baitapkhoa4.payload.RequestLogin;
import com.cybersoft.baitapkhoa4.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserServiceImp userServiceImp;

    @PostMapping
    public ResponseEntity<?> login( @RequestBody RequestLogin requestLogin){
        return ResponseHelper.getResponse(userServiceImp.createToken(requestLogin), HttpStatus.OK);
    }
}
