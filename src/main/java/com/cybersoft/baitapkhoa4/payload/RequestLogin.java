package com.cybersoft.baitapkhoa4.payload;

import lombok.Data;

@Data
public class RequestLogin {
    private String email;
    private String password;
}
