package com.lastToCreateProject.aarealestate.controller;

import com.lastToCreateProject.aarealestate.converter.EstateConverter;
import com.lastToCreateProject.aarealestate.dto.EstateDto;
import com.lastToCreateProject.aarealestate.dto.EstateResponse;
import com.lastToCreateProject.aarealestate.model.Estate;
import com.lastToCreateProject.aarealestate.service.EstateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/estates")
@AllArgsConstructor
public class EstateController {

    private final EstateService estateService;
    private final EstateConverter estateConverter;

    @PostMapping
    public ResponseEntity<EstateResponse> save(@RequestBody @Valid EstateDto estateDto) {
        Estate estate = estateConverter.toEstate(estateDto);
        Estate savedEstate = estateService.save(estate);
        return ResponseEntity.ok().build();
    }
}
