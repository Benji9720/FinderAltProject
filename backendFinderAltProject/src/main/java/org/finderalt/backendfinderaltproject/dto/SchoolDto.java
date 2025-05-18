package org.finderalt.backendfinderaltproject.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
    private Long id;
    private String name;
    private String address;
    private List<String> sharedNews;
}
