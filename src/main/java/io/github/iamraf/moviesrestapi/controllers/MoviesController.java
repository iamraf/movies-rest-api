package io.github.iamraf.moviesrestapi.controllers;

import io.github.iamraf.moviesrestapi.entities.Movie;
import io.github.iamraf.moviesrestapi.exceptions.MovieNotFoundException;
import io.github.iamraf.moviesrestapi.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/movies")
public class MoviesController {

    private final MoviesService service;

    @Autowired
    public MoviesController(MoviesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return service.findAll();
    }

    @GetMapping(value = {"/movie/{id}"})
    public Movie getMovie(@PathVariable Integer id) {
        return service.findMovieById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found"));
    }
}