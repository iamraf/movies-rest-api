package io.github.iamraf.moviesrestapi.controllers;

import io.github.iamraf.moviesrestapi.entities.Movie;
import io.github.iamraf.moviesrestapi.exceptions.MovieNotFoundException;
import io.github.iamraf.moviesrestapi.exceptions.PageNotFoundException;
import io.github.iamraf.moviesrestapi.exceptions.SortTableNotSupportedException;
import io.github.iamraf.moviesrestapi.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(params = {"sort"})
    public List<Movie> getSortedMovies(@RequestParam("sort") String sort) {
        if (!sort.equals("title") && !sort.equals("year")) {
            throw new SortTableNotSupportedException("Table specified not supported");
        }

        return service.findAll(sort);
    }

    @GetMapping(value = {"/movie/{id}"})
    public Movie getMovie(@PathVariable Integer id) {
        return service.findMovieById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found"));
    }

    @GetMapping(params = {"page", "size"})
    public List<Movie> getPagedMovies(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<Movie> resultPage = service.findAll(page, size);

        if (page > resultPage.getTotalPages()) {
            throw new PageNotFoundException("Page not found");
        }

        return resultPage.getContent();
    }

    @GetMapping(params = {"page", "size", "sort"})
    public List<Movie> getPagedMovies(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("sort") String sort) {
        if (!sort.equals("title") && !sort.equals("year")) {
            throw new SortTableNotSupportedException("Table specified not supported");
        }

        Page<Movie> resultPage = service.findAll(page, size, sort);

        if (page > resultPage.getTotalPages()) {
            throw new PageNotFoundException("Page not found");
        }

        return resultPage.getContent();
    }
}