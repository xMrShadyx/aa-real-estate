package com.lastToCreateProject.aarealestate.converter;

import com.lastToCreateProject.aarealestate.dto.CityDto;
import com.lastToCreateProject.aarealestate.model.City;
import com.lastToCreateProject.aarealestate.model.Neighborhood;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CityConverter {

    public CityDto toCityDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .neighborhoodIds(city.getNeighborhoods()
                        .stream()
                        .map(Neighborhood::getId)
                        .collect(Collectors.toSet()))
                .build();
    }

    public City toCity(CityDto cityDto) {
        return City.builder()
                .id(cityDto.getId())
                .name(cityDto.getName())
                .neighborhoods(cityDto.getNeighborhoodIds()
                        .stream()
                        .map((neighborhoodId) -> Neighborhood.builder()
                                .id(neighborhoodId).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
