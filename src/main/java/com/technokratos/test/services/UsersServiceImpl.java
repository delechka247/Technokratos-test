package com.technokratos.test.services;

import com.technokratos.test.dto.UserDto;
import com.technokratos.test.dto.UserForm;
import com.technokratos.test.models.User;
import com.technokratos.test.repositories.UsersRepository;
import com.technokratos.test.utils.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDto addUser(UserForm userForm) {
        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .gender(Gender.valueOf(userForm.getGender()))
                .age(userForm.getAge())
                .build();

        return UserDto.getUserDto(usersRepository.save(user));
    }

    @Override
    public List<UserDto> getAll() {
        return usersRepository.findAll().stream().map(UserDto::getUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getOneById(String id) {
        Optional<User> user = usersRepository.findById(id);
        UserDto userDto = UserDto.builder().build();
        if(user.isPresent()) {
            userDto = UserDto.getUserDto(user.get());
        }
        return userDto;
    }

    @Override
    public UserDto updateUser(String id, UserForm userForm) {
        User userForUpdate = usersRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        userForUpdate.setAge(userForm.getAge());
        userForUpdate.setGender(Gender.valueOf(userForm.getGender()));
        userForUpdate.setFirstName(userForm.getFirstName());
        userForUpdate.setLastName(userForm.getLastName());
        usersRepository.save(userForUpdate);
        return UserDto.getUserDto(userForUpdate);
    }

    @Override
    public void deleteUser(String id) {
        usersRepository.deleteById(id);
    }


}
