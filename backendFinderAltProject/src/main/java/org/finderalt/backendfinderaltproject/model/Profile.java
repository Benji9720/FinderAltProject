package org.finderalt.backendfinderaltproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;
    private String location;

    @ElementCollection
    @CollectionTable(name = "profile_skills", joinColumns = @JoinColumn(name = "profile_id"))
    @Column(name = "skill")
    private List<String> skills;

    @ElementCollection
    @CollectionTable(name = "profile_values", joinColumns = @JoinColumn(name = "profile_id"))
    @Column(name = "value")
    private List<String> values;

    @ElementCollection
    @CollectionTable(name = "profile_expectations", joinColumns = @JoinColumn(name = "profile_id"))
    @Column(name = "expectation")
    private List<String> expectations;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
