package org.finderalt.backendfinderaltproject.repository;

import org.finderalt.backendfinderaltproject.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
