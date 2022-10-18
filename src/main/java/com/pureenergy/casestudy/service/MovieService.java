package com.pureenergy.casestudy.service;

import com.pureenergy.casestudy.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    List<MovieDTO> getAllMovies();

    MovieDTO getMovieById(Long id) throws Exception;

    MovieDTO createMovie(MovieDTO movieDTO);
}
