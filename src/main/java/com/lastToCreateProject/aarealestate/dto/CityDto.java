package com.lastToCreateProject.aarealestate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder

public class CityDto {

    private Long id;
    private String name;

    private Set<Long> neighborhoodIds;
}
