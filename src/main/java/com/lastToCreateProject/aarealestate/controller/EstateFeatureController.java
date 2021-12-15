package com.lastToCreateProject.aarealestate.controller;

import com.lastToCreateProject.aarealestate.model.EstateFeature;
import com.lastToCreateProject.aarealestate.service.EstateFeatureService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/estate-feature")
@AllArgsConstructor
public class EstateFeatureController {

    private final EstateFeatureService estateFeatureService;

    @PostMapping
    public ResponseEntity<EstateFeature> save(@RequestBody @Valid EstateFeature estateFeature) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estateFeatureService.save(estateFeature));
    }
}
