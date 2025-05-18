package org.finderalt.backendfinderaltproject.service;

import lombok.RequiredArgsConstructor;
import org.finderalt.backendfinderaltproject.dto.AlternantInfoDto;
import org.finderalt.backendfinderaltproject.model.AlternantInfo;
import org.finderalt.backendfinderaltproject.model.User;
import org.finderalt.backendfinderaltproject.repository.AlternantInfoRepository;
import org.finderalt.backendfinderaltproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlternantInfoService {

    private final AlternantInfoRepository alternantInfoRepository;
    private final UserRepository userRepository;

    public AlternantInfoDto create(AlternantInfoDto dto) {
        Optional<User> user = userRepository.findById(dto.getUserId());
        if (user.isEmpty()) return null;

        AlternantInfo info = AlternantInfo.builder()
                .formation(dto.getFormation())
                .schoolName(dto.getSchoolName())
                .user(user.get())
                .build();

        return toDto(alternantInfoRepository.save(info));
    }

    private AlternantInfoDto toDto(AlternantInfo a) {
        return AlternantInfoDto.builder()
                .id(a.getId())
                .formation(a.getFormation())
                .schoolName(a.getSchoolName())
                .userId(a.getUser().getId())
                .build();
    }
}
