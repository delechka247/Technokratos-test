package com.technokratos.test.dto;

import com.technokratos.test.utils.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserForm {
    private String firstName;
    private String lastName;
    private Gender gender;
    private Integer age;
}
