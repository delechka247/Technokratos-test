package com.technokratos.test.services;

import com.technokratos.test.dto.FilmDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class FilmsServiceImpl implements FilmsService {

    @Override
    public FilmDto getFilmDtoFromMap(Map map) {
        List<Map> listOfMap = (List<Map>) map.get("results");
        Map film = listOfMap.get(0);
        FilmDto filmDto = FilmDto.builder()
                .overview(film.get("overview").toString())
                .releaseDate(Date.valueOf(film.get("releaseDate").toString()))
                .title(film.get("title").toString())
                .voteAverage(Double.valueOf(film.get("voteAverage").toString()))
                .voteCount(Long.valueOf(film.get("voteCount").toString()))
                .originalTitle(film.get("originalTitle").toString())
                .originalLanguage(film.get("originalLanguage").toString())
                .adult(Boolean.valueOf(film.get("adult").toString()))
                .build();
        return filmDto;
    }
}
