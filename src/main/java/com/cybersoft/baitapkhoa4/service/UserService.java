package com.cybersoft.baitapkhoa4.service;

import com.cybersoft.baitapkhoa4.configuration.jwt.JwtUltilities;
import com.cybersoft.baitapkhoa4.dto.UserDto;
import com.cybersoft.baitapkhoa4.mapper.UserMapper;
import com.cybersoft.baitapkhoa4.model.User;
import com.cybersoft.baitapkhoa4.payload.RequestLogin;
import com.cybersoft.baitapkhoa4.repository.UserRepository;
import com.cybersoft.baitapkhoa4.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUltilities jwtUltilities;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createNewUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public String createToken(RequestLogin requestLogin) {
        return jwtUltilities.generateToken(requestLogin.getEmail());
    }
}
