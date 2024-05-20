package com.zolochevskyi.service;

import com.zolochevskyi.dto.UserDto;
import com.zolochevskyi.domain.User;

import java.util.List;

public interface UserService {

    String createUser(UserDto userDto);

    List<UserDto> getUsers();
}