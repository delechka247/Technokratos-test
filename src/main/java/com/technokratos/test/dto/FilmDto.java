package com.technokratos.test.dto;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmDto {
            private String overview;
            private Date releaseDate;
            private String originalTitle;
            private String originalLanguage;
            private String title;
            private Long voteCount;
            private Double voteAverage;
            private Boolean adult;
}
