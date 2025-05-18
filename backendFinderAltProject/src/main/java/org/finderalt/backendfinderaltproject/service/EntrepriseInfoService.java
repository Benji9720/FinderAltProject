package org.finderalt.backendfinderaltproject.service;

import lombok.RequiredArgsConstructor;
import org.finderalt.backendfinderaltproject.dto.EntrepriseInfoDto;
import org.finderalt.backendfinderaltproject.model.EntrepriseInfo;
import org.finderalt.backendfinderaltproject.model.User;
import org.finderalt.backendfinderaltproject.repository.EntrepriseInfoRepository;
import org.finderalt.backendfinderaltproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntrepriseInfoService {

    private final EntrepriseInfoRepository entrepriseInfoRepository;
    private final UserRepository userRepository;

    public EntrepriseInfoDto create(EntrepriseInfoDto dto) {
        Optional<User> user = userRepository.findById(dto.getUserId());
        if (user.isEmpty()) return null;

        EntrepriseInfo info = EntrepriseInfo.builder()
                .entrepriseName(dto.getEntrepriseName())
                .secteur(dto.getSecteur())
                .description(dto.getDescription())
                .user(user.get())
                .build();

        return toDto(entrepriseInfoRepository.save(info));
    }

    private EntrepriseInfoDto toDto(EntrepriseInfo e) {
        return EntrepriseInfoDto.builder()
                .id(e.getId())
                .entrepriseName(e.getEntrepriseName())
                .secteur(e.getSecteur())
                .description(e.getDescription())
                .userId(e.getUser().getId())
                .build();
    }
}
