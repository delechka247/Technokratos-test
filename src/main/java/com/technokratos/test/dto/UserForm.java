package com.technokratos.test.dto;

import com.technokratos.test.utils.Gender;
import com.technokratos.test.validation.ValidAge;
import com.technokratos.test.validation.ValidGender;
import com.technokratos.test.validation.ValidName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserForm {
    @ValidName(message = "Invalid first name")
    private String firstName;
    @ValidName(message = "Invalid last name")
    private String lastName;
    @ValidGender
    private String gender;
    @ValidAge
    private Integer age;
}
