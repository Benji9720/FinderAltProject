package org.finderalt.backendfinderaltproject.controller;

import lombok.RequiredArgsConstructor;
import org.finderalt.backendfinderaltproject.dto.MatchDto;
import org.finderalt.backendfinderaltproject.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @PostMapping
    public ResponseEntity<MatchDto> createMatch(@RequestBody MatchDto dto) {
        return ResponseEntity.ok(matchService.createMatch(dto));
    }
}
