package org.finderalt.backendfinderaltproject.controller;

import lombok.RequiredArgsConstructor;
import org.finderalt.backendfinderaltproject.dto.LoginRequestDto;
import org.finderalt.backendfinderaltproject.dto.LoginResponseDto;
import org.finderalt.backendfinderaltproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequest) {
        System.out.println("Reçu : " + loginRequest);
        LoginResponseDto response = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.status(401).build();
    }

}
