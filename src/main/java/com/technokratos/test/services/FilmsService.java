package com.technokratos.test.services;

import com.technokratos.test.dto.FilmDto;

import java.util.Map;

public interface FilmsService {
    FilmDto getFilmDtoFromMap(Map map);
}
