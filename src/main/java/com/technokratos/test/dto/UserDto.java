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
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Integer age;

    public static UserDto getUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .age(user.getAge())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .gender(user.getGender())
                .build();
    }
}
