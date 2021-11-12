package com.technokratos.test.models;

import com.technokratos.test.utils.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Builder
@Document
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Integer age;
    private Film film;

}
