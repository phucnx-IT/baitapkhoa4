package com.cybersoft.baitapkhoa4.mapper;

import com.cybersoft.baitapkhoa4.dto.UserDto;
import com.cybersoft.baitapkhoa4.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
