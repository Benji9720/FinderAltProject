package org.finderalt.backendfinderaltproject.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlternantInfoDto {
    private Long id;
    private String formation;
    private String schoolName;
    private Long userId;
}
