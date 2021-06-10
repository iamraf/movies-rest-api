package io.github.iamraf.moviesrestapi.repositories;

import io.github.iamraf.moviesrestapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
