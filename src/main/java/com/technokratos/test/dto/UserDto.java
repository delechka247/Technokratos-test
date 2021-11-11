package com.technokratos.test.dto;

import com.technokratos.test.models.User;
import com.technokratos.test.utils.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private String firstName;
    private String lastName;
    private Gender gender;
    private Integer age;

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.age = user.getAge();
        this.gender = user.getGender();
    }
}
