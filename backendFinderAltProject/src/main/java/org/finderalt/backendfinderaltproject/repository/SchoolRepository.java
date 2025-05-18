package org.finderalt.backendfinderaltproject.repository;

import org.finderalt.backendfinderaltproject.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
