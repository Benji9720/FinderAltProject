package org.finderalt.backendfinderaltproject.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String fullName;
    private String role; // String ou Enum selon le front
}
