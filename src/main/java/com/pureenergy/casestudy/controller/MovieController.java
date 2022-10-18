package com.pureenergy.casestudy.controller;

import com.pureenergy.casestudy.dto.MovieDTO;
import com.pureenergy.casestudy.entity.ResponseWrapper;
import com.pureenergy.casestudy.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllMovies(){
        return ResponseEntity
                .ok(new ResponseWrapper("All movies are retrieved.",movieService.getAllMovies()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper> getMovieById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity
                .ok(new ResponseWrapper("Movie id " + id + " is retrieved.",movieService.getMovieById(id)));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createMovie(@RequestBody MovieDTO movieDTO){
        return ResponseEntity
                .ok(new ResponseWrapper("Movie is created", movieService.createMovie(movieDTO)));
    }
}
