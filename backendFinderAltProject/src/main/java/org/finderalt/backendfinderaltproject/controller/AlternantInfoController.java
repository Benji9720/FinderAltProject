package org.finderalt.backendfinderaltproject.controller;

import lombok.RequiredArgsConstructor;
import org.finderalt.backendfinderaltproject.dto.AlternantInfoDto;
import org.finderalt.backendfinderaltproject.service.AlternantInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alternants")
@RequiredArgsConstructor
public class AlternantInfoController {

    private final AlternantInfoService alternantInfoService;

    @PostMapping
    public ResponseEntity<AlternantInfoDto> create(@RequestBody AlternantInfoDto dto) {
        return ResponseEntity.ok(alternantInfoService.create(dto));
    }
}
