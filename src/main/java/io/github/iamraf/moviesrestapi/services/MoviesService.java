package io.github.iamraf.moviesrestapi.services;

import io.github.iamraf.moviesrestapi.entities.Movie;
import io.github.iamraf.moviesrestapi.exceptions.MovieAlreadyExistsException;
import io.github.iamraf.moviesrestapi.exceptions.MovieNotFoundException;
import io.github.iamraf.moviesrestapi.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Movie> findAll(String sort) {
        return repository.findAll(Sort.by(sort));
    }

    public Optional<Movie> findMovieById(int id) {
        return repository.findById(id);
    }

    public Page<Movie> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        return repository.findAll(pageable);
    }

    public Page<Movie> findAll(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(sort));

        return repository.findAll(pageable);
    }

    public void add(Movie movie) {
        Optional<Movie> result = repository.findMovieByTitleAndDescription(movie.getTitle(), movie.getDescription());

        if (result.isPresent()) {
            throw new MovieAlreadyExistsException("Movie already exist");
        }

        repository.save(movie);
    }

    public void delete(int id) {
        if (!repository.existsById(id)) {
            throw new MovieNotFoundException("Movie does not exist");
        }

        repository.deleteById(id);
    }

    @Transactional
    public void update(Movie movie) {
        Movie result = repository.findById(movie.getId())
                .orElseThrow(() -> new MovieNotFoundException("Movie does not exist"));

        String title = movie.getTitle();
        if (title != null && !title.isEmpty() && !title.equals(result.getTitle())) {
            result.setTitle(title);
        }

        String description = movie.getDescription();
        if (description != null && !description.isEmpty() && !description.equals(result.getDescription())) {
            result.setDescription(description);
        }

        int year = movie.getYear();
        if (year != 0 && year != result.getYear()) {
            result.setYear(year);
        }
    }
}
