package io.github.iamraf.moviesrestapi.repositories;

import io.github.iamraf.moviesrestapi.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer> {

}