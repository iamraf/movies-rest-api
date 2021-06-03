package io.github.iamraf.moviesrestapi.services;

import io.github.iamraf.moviesrestapi.entities.Movie;
import io.github.iamraf.moviesrestapi.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {

    private final MoviesRepository repository;

    @Autowired
    public MoviesService(MoviesRepository repository) {
        this.repository = repository;
    }

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public Optional<Movie> findMovieById(int id) {
        return repository.findById(id);
    }
}
