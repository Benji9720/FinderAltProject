package org.finderalt.backendfinderaltproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Swipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "swiper_id")
    private User swiper;

    @ManyToOne
    @JoinColumn(name = "swiped_user_id")
    private User swipedUser;

    private boolean liked;

    private LocalDateTime swipedAt;
}