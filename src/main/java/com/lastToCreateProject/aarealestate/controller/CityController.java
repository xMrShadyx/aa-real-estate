package com.lastToCreateProject.aarealestate.controller;

import com.lastToCreateProject.aarealestate.converter.CityConverter;
import com.lastToCreateProject.aarealestate.dto.CityDetachNeighborhoodDto;
import com.lastToCreateProject.aarealestate.dto.CityDto;
import com.lastToCreateProject.aarealestate.model.City;
import com.lastToCreateProject.aarealestate.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cities")
public class CityController {
    private final CityService cityService;
    private final CityConverter cityConverter;

    @Autowired
    public CityController(CityService cityService, CityConverter cityConverter) {
        this.cityService = cityService;
        this.cityConverter = cityConverter;
    }

    @PostMapping
    public ResponseEntity<CityDto> save(@RequestBody CityDto cityDto) {
        City city = cityConverter.toCity(cityDto);
        City savedCity = cityService.save(city);
        CityDto cityDtoResponse = cityConverter.toCityDto(savedCity);
        return ResponseEntity.ok(cityDtoResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CityDto> findById(@PathVariable Long id) {
        City foundCity = cityService.findById(id);
        CityDto cityDto = cityConverter.toCityDto(foundCity);

        return ResponseEntity.ok(cityDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CityDto> update(@RequestBody CityDto cityDto, @PathVariable Long id) {
        City city = cityConverter.toCity(cityDto);
        City savedCity = cityService.update(city, id);
        CityDto cityDtoResponse = cityConverter.toCityDto(savedCity);
        return ResponseEntity.ok(cityDtoResponse);
    }

    @PutMapping(value = "/detach")
    public ResponseEntity<HttpStatus> detach(@RequestBody CityDetachNeighborhoodDto cityDetachNeighborhoodDto) {
        cityService.detachCityNeighborhood(cityDetachNeighborhoodDto.getCityId(), cityDetachNeighborhoodDto.getNeighborhoods());
        return ResponseEntity.ok().build();
    }
}
