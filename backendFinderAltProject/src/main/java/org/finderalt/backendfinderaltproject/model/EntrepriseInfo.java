package org.finderalt.backendfinderaltproject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntrepriseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String entrepriseName;

    private String secteur;

    private String description;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
