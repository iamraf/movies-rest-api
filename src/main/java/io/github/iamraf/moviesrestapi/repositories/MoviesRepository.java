package io.github.iamraf.moviesrestapi.repositories;

import io.github.iamraf.moviesrestapi.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer> {

    Page<Movie> findAll(Pageable pageable);

    Optional<Movie> findMovieByTitleAndDescription(String title, String description);
}