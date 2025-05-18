package org.finderalt.backendfinderaltproject.controller;

import lombok.RequiredArgsConstructor;
import org.finderalt.backendfinderaltproject.dto.ProfileDto;
import org.finderalt.backendfinderaltproject.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDto> getProfile(@PathVariable Long id) {
        ProfileDto profile = profileService.getProfileById(id);
        return profile != null ? ResponseEntity.ok(profile) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProfileDto> createProfile(@RequestBody ProfileDto dto) {
        return ResponseEntity.ok(profileService.createProfile(dto));
    }
}
