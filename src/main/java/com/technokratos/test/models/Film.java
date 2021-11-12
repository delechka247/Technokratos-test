package com.technokratos.test.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Film {
    private String overview;
    private Date releaseDate;
    private String originalTitle;
    private String originalLanguage;
    private String title;
    private Long voteCount;
    private Double voteAverage;
    private Boolean adult;
}
