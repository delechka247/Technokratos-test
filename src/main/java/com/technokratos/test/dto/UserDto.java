package com.technokratos.test.dto;

import com.technokratos.test.models.Film;
import com.technokratos.test.models.User;
import com.technokratos.test.utils.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Integer age;
    private FilmDto filmDto;

    public static UserDto getUserDto(User user) {
        Film film = user.getFilm();
        FilmDto filmDto = FilmDto.builder()
                .adult(film.getAdult())
                .originalLanguage(film.getOriginalLanguage())
                .originalTitle(film.getOriginalTitle())
                .overview(film.getOverview())
                .releaseDate(film.getReleaseDate())
                .title(film.getTitle())
                .voteAverage(film.getVoteAverage())
                .voteCount(film.getVoteCount())
                .build();

        return UserDto.builder()
                .id(user.getId())
                .age(user.getAge())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .gender(user.getGender())
                .filmDto(filmDto)
                .build();
    }
}
