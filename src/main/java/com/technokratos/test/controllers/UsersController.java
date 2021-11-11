package com.technokratos.test.controllers;

import com.technokratos.test.dto.UserDto;
import com.technokratos.test.dto.UserForm;
import com.technokratos.test.services.UsersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(usersService.getAll());
    }

    @PostMapping("/users")
    @ApiOperation(value = "Добавление пользователя")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно добавлено", response = UserDto.class)})
    public ResponseEntity<UserDto> addUser(@RequestBody UserForm userForm) {
        return ResponseEntity.ok(usersService.addUser(userForm));
    }
}
