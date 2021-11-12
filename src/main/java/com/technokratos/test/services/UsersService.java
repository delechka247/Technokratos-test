package com.technokratos.test.services;

import com.technokratos.test.dto.FilmDto;
import com.technokratos.test.dto.UserDto;
import com.technokratos.test.dto.UserForm;

import java.util.List;

public interface UsersService {
    UserDto addUser(UserForm userForm, FilmDto filmDto);
    List<UserDto> getAll();
    UserDto getOneById(String id);
    UserDto updateUser(String id, UserForm userForm, FilmDto filmDto);
    void deleteUser(String id);
}
