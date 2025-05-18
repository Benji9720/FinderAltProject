package org.finderalt.backendfinderaltproject.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntrepriseInfoDto {
    private Long id;
    private String entrepriseName;
    private String secteur;
    private String description;
    private Long userId;
}
