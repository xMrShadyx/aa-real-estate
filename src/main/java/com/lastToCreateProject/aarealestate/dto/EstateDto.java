package com.lastToCreateProject.aarealestate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class EstateDto {
    private Long id;

    private String description;

    private BigDecimal pureArea;

    private BigDecimal builtUpArea;

    private Long floorId;

    private Long cityId;

    private Set<Long> estateFeaturesIds;
}
