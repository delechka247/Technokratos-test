package com.technokratos.test.services;

import com.technokratos.test.dto.UserDto;
import com.technokratos.test.dto.UserForm;
import com.technokratos.test.models.User;
import com.technokratos.test.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDto addUser(UserForm userForm) {
        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .gender(userForm.getGender())
                .age(userForm.getAge())
                .build();

        return new UserDto(usersRepository.save(user));
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }
}
