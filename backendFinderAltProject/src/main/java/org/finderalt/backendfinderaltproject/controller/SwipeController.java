package org.finderalt.backendfinderaltproject.controller;

import lombok.RequiredArgsConstructor;
import org.finderalt.backendfinderaltproject.dto.SwipeDto;
import org.finderalt.backendfinderaltproject.service.SwipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/swipes")
@RequiredArgsConstructor
public class SwipeController {

    private final SwipeService swipeService;

    @PostMapping
    public ResponseEntity<SwipeDto> swipe(@RequestBody SwipeDto dto) {
        return ResponseEntity.ok(swipeService.createSwipe(dto));
    }

    @GetMapping("/employeur/{employeurId}/liked/{alternantId}")
    public ResponseEntity<Boolean> hasEmployeurLikedAlternant(@PathVariable Long employeurId, @PathVariable Long alternantId) {
        return ResponseEntity.ok(swipeService.hasUserLikedTarget(employeurId, alternantId));
    }

}
