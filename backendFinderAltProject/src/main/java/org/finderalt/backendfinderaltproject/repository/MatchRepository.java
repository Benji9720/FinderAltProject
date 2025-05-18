package org.finderalt.backendfinderaltproject.repository;

import org.finderalt.backendfinderaltproject.model.Match;
import org.finderalt.backendfinderaltproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByAlternant(User alternant);
    List<Match> findByEmployeur(User employeur);
}
