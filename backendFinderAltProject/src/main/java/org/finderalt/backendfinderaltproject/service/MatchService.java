package org.finderalt.backendfinderaltproject.service;

import lombok.RequiredArgsConstructor;
import org.finderalt.backendfinderaltproject.dto.MatchDto;
import org.finderalt.backendfinderaltproject.model.Match;
import org.finderalt.backendfinderaltproject.model.User;
import org.finderalt.backendfinderaltproject.repository.MatchRepository;
import org.finderalt.backendfinderaltproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final UserRepository userRepository;

    public MatchDto createMatch(MatchDto dto) {
        Optional<User> alt = userRepository.findById(dto.getAlternantId());
        Optional<User> emp = userRepository.findById(dto.getEmployeurId());

        if (alt.isEmpty() || emp.isEmpty()) return null;

        Match match = Match.builder()
                .alternant(alt.get())
                .employeur(emp.get())
                .matched(dto.isMatched())
                .matchedAt(LocalDateTime.now())
                .build();

        return toDto(matchRepository.save(match));
    }

    private MatchDto toDto(Match match) {
        return MatchDto.builder()
                .id(match.getId())
                .alternantId(match.getAlternant().getId())
                .employeurId(match.getEmployeur().getId())
                .matched(match.isMatched())
                .matchedAt(match.getMatchedAt())
                .build();
    }
}
