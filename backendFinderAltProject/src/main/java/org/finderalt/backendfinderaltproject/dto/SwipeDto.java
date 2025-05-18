package org.finderalt.backendfinderaltproject.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SwipeDto {
    private Long id;
    private Long swiperId;
    private Long swipedUserId;
    private boolean liked;
    private LocalDateTime swipedAt;
}
