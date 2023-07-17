package com.cybersoft.baitapkhoa4.service.imp;

import com.cybersoft.baitapkhoa4.dto.UserDto;
import com.cybersoft.baitapkhoa4.payload.RequestLogin;

public interface UserServiceImp {
    void createNewUser(UserDto userDto);
    String createToken (RequestLogin requestLogin);
}
