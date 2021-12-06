package com.lastToCreateProject.aarealestate.converter;

import com.lastToCreateProject.aarealestate.dto.NeighborhoodDto;
import com.lastToCreateProject.aarealestate.model.Neighborhood;
import org.springframework.stereotype.Component;

@Component
public class NeighborhoodConverter {

    public NeighborhoodDto toNeighborhoodDto(Neighborhood neighborhood) {
        return NeighborhoodDto.builder()
                .id(neighborhood.getId())
                .name(neighborhood.getName())
                .build();
    };

    public Neighborhood toNeighborhood(NeighborhoodDto neighborhoodDto) {
        return Neighborhood.builder()
                .id(neighborhoodDto.getId())
                .name(neighborhoodDto.getName())
                .build();
    }
}
