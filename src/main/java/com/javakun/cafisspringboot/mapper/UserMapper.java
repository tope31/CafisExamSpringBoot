package com.javakun.cafisspringboot.mapper;

import com.javakun.cafisspringboot.model.User;
import com.javakun.cafisspringboot.model.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toLoginDto(User user);
    List<UserDTO> toEmployeeDtos(List<User> usersList);
}
