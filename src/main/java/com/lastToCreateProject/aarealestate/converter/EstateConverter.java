package com.lastToCreateProject.aarealestate.converter;

import com.lastToCreateProject.aarealestate.dto.EstateDto;
import com.lastToCreateProject.aarealestate.dto.EstateResponse;
import com.lastToCreateProject.aarealestate.model.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EstateConverter {

    public Estate toEstate(EstateDto estateDto) {
        return Estate.builder()
                .id(estateDto.getId())
                .city(City.builder().id(estateDto.getCityId()).build())
                .floor(Floor.builder().id(estateDto.getFloorId()).build())
                .description(estateDto.getDescription())
                .quadrature(Quadrature.builder()
                        .pureArea(estateDto.getPureArea())
                        .builtUpArea(estateDto.getBuiltUpArea()).build())
                .estateFeatures(estateDto.getEstateFeaturesIds()
                        .stream()
                        .map(estateFeatureId -> EstateFeature.builder()
                                .id(estateFeatureId)
                                .build())
                        .collect(Collectors.toSet())).build();
    }

    public EstateResponse toEstateResponse(Estate estate) {
        return null;
    }
}
