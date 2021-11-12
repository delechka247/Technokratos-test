package com.technokratos.test.services;

import com.technokratos.test.dto.UserDto;
import com.technokratos.test.dto.UserForm;

import java.util.List;

public interface UsersService {
    UserDto addUser(UserForm userForm);
    List<UserDto> getAll();
    UserDto getOneById(String id);
    UserDto updateUser(String id, UserForm userForm);
    void deleteUser(String id);
}
