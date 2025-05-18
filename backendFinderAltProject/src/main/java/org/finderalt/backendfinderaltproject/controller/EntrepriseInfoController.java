package org.finderalt.backendfinderaltproject.controller;

import lombok.RequiredArgsConstructor;
import org.finderalt.backendfinderaltproject.dto.EntrepriseInfoDto;
import org.finderalt.backendfinderaltproject.service.EntrepriseInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entreprises")
@RequiredArgsConstructor
public class EntrepriseInfoController {

    private final EntrepriseInfoService entrepriseInfoService;

    @PostMapping
    public ResponseEntity<EntrepriseInfoDto> create(@RequestBody EntrepriseInfoDto dto) {
        return ResponseEntity.ok(entrepriseInfoService.create(dto));
    }
}
