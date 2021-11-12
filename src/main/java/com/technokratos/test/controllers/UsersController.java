package com.technokratos.test.controllers;

import com.technokratos.test.dto.UserDto;
import com.technokratos.test.dto.UserForm;
import com.technokratos.test.services.UsersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    @ApiOperation(value = "Просмотр резюме всех пользователей")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(usersService.getAll());
    }

    @GetMapping("/users/{id}")
    @ApiOperation(value = "Просмотр резюме одного пользователя")
    public ResponseEntity<?> getOneUser(@PathVariable String id) {
        UserDto user = usersService.getOneById(id);
        if(user.getId() != null)
            return ResponseEntity.ok(user);
        return new ResponseEntity<>("Пользователь не существует", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/users")
    @ApiOperation(value = "Добавление резюме пользователя")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно добавлено", response = UserDto.class)})
    public ResponseEntity<?> addUser(@Valid @RequestBody UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(f -> f.getDefaultMessage())
                    .collect(Collectors.toList());
            return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(usersService.addUser(userForm));
    }
    
    @PutMapping("/users/{id}")
    @ApiOperation(value = "Изменение резюме пользователя")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно изменено", response = UserDto.class)})
    public ResponseEntity<UserDto> updateUser(@PathVariable String id, @Valid @RequestBody UserForm userForm) {
        return ResponseEntity.ok(usersService.updateUser(id, userForm));
    }

    @DeleteMapping("/users/{id}")
    @ApiOperation(value = "Удаление резюме пользователя")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно удалено")})
    public ResponseEntity<?> updateUser(@PathVariable String id) {
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
