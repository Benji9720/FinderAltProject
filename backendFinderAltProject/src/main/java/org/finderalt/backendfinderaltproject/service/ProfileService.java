package org.finderalt.backendfinderaltproject.service;

import lombok.RequiredArgsConstructor;
import org.finderalt.backendfinderaltproject.dto.ProfileDto;
import org.finderalt.backendfinderaltproject.model.Profile;
import org.finderalt.backendfinderaltproject.model.User;
import org.finderalt.backendfinderaltproject.repository.ProfileRepository;
import org.finderalt.backendfinderaltproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public ProfileDto createProfile(ProfileDto dto) {
        Optional<User> userOpt = userRepository.findById(dto.getUserId());
        if (userOpt.isEmpty()) return null;

        Profile profile = Profile.builder()
                .bio(dto.getBio())
                .location(dto.getLocation())
                .skills(dto.getSkills())
                .values(dto.getValues())
                .expectations(dto.getExpectations())
                .user(userOpt.get())
                .build();

        return toDto(profileRepository.save(profile));
    }

    public ProfileDto getProfileById(Long id) {
        return profileRepository.findById(id).map(this::toDto).orElse(null);
    }

    private ProfileDto toDto(Profile p) {
        return ProfileDto.builder()
                .id(p.getId())
                .bio(p.getBio())
                .location(p.getLocation())
                .skills(p.getSkills())
                .values(p.getValues())
                .expectations(p.getExpectations())
                .userId(p.getUser().getId())
                .build();
    }
}
