package org.finderalt.backendfinderaltproject.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDto {
    private Long id;
    private String email;
    private String fullName;
    private String role;
}
