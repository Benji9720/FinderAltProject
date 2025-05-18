package org.finderalt.backendfinderaltproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "match_table")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alternant_id")
    private User alternant;

    @ManyToOne
    @JoinColumn(name = "employeur_id")
    private User employeur;

    private boolean matched;

    private LocalDateTime matchedAt;
}
