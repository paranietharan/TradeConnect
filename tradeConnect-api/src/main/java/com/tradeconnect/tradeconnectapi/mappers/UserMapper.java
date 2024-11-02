package com.tradeconnect.tradeconnectapi.mappers;

import com.tradeconnect.tradeconnectapi.dto.SignUpDto;
import com.tradeconnect.tradeconnectapi.dto.UserDto;
import com.tradeconnect.tradeconnectapi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
