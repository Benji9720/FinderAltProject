package org.finderalt.backendfinderaltproject.service;

import lombok.RequiredArgsConstructor;
import org.finderalt.backendfinderaltproject.dto.SchoolDto;
import org.finderalt.backendfinderaltproject.model.School;
import org.finderalt.backendfinderaltproject.repository.SchoolRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolDto create(SchoolDto dto) {
        School school = School.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .sharedNews(dto.getSharedNews())
                .build();

        return toDto(schoolRepository.save(school));
    }

    private SchoolDto toDto(School s) {
        return SchoolDto.builder()
                .id(s.getId())
                .name(s.getName())
                .address(s.getAddress())
                .sharedNews(s.getSharedNews())
                .build();
    }
}
