package org.finderalt.backendfinderaltproject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlternantInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String formation;

    private String schoolName;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}