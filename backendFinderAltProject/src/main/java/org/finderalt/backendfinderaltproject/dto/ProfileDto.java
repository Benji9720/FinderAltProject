package org.finderalt.backendfinderaltproject.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
    private Long id;
    private String bio;
    private String location;
    private List<String> skills;
    private List<String> values;
    private List<String> expectations;
    private Long userId;
}
