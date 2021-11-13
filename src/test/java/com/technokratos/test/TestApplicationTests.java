package com.technokratos.test;

import com.technokratos.test.dto.UserDto;
import com.technokratos.test.dto.UserForm;
import com.technokratos.test.utils.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class TestApplicationTests {

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void contextLoads() {
    }

    @Test
    public void addUser() {
        UserForm userForm = UserForm.builder()
                .age(26)
                .firstName("Мария")
                .lastName("Петрова")
                .gender("FEMALE")
                .filmTitle("Titanic")
                .build();

        ResponseEntity<UserDto> response = restTemplate.postForEntity("http://localhost:8080/users", userForm, UserDto.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().getId(), notNullValue());
        assertThat(response.getBody().getFirstName(), is("Мария"));
        assertThat(response.getBody().getLastName(), is("Петрова"));
        assertThat(response.getBody().getAge(), is(26));
        assertThat(response.getBody().getGender(), is(Gender.FEMALE));
    }

    @Test
    public void getUserById() {
        ResponseEntity<UserDto> response = restTemplate.getForEntity("http://localhost:8080/users/618f0a6269464b5630aaf4d6", UserDto.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().getId(), notNullValue());
        assertThat(response.getBody().getFirstName(), is("Мария"));
        assertThat(response.getBody().getLastName(), is("Петрова"));
        assertThat(response.getBody().getAge(), is(26));
        assertThat(response.getBody().getGender(), is(Gender.FEMALE));
    }

}
