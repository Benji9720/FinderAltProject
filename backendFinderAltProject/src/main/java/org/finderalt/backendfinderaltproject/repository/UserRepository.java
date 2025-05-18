package org.finderalt.backendfinderaltproject.repository;

import org.finderalt.backendfinderaltproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
