package org.finderalt.backendfinderaltproject.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchDto {
    private Long id;
    private Long alternantId;
    private Long employeurId;
    private boolean matched;
    private LocalDateTime matchedAt;
}
