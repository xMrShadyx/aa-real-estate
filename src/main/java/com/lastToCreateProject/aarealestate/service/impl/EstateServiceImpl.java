package com.lastToCreateProject.aarealestate.service.impl;

import com.lastToCreateProject.aarealestate.model.Estate;
import com.lastToCreateProject.aarealestate.repository.EstateRepository;
import com.lastToCreateProject.aarealestate.service.CityService;
import com.lastToCreateProject.aarealestate.service.EstateFeatureService;
import com.lastToCreateProject.aarealestate.service.EstateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class EstateServiceImpl implements EstateService {

    private final EstateRepository estateRepository;
    private final EstateFeatureService estateFeatureService;
    private final CityService cityService;

    @Override
    public Estate save(Estate estate) {
        return null;
    }

    @Override
    public Set<Estate> findAll() {
        return new HashSet<>(estateRepository.findAll());
    }
}
