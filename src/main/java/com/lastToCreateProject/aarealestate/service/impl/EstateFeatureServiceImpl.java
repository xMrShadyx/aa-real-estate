package com.lastToCreateProject.aarealestate.service.impl;

import com.lastToCreateProject.aarealestate.exceptions.ResourceNotFoundException;
import com.lastToCreateProject.aarealestate.model.EstateFeature;
import com.lastToCreateProject.aarealestate.repository.EstateFeatureRepository;
import com.lastToCreateProject.aarealestate.service.EstateFeatureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstateFeatureServiceImpl implements EstateFeatureService {

    private final EstateFeatureRepository estateFeatureRepository;

    @Override
    public EstateFeature save(EstateFeature estateFeature) {
        return estateFeatureRepository.save(estateFeature);
    }

    @Override
    public EstateFeature findById(Long id) {
        return null;
    }

    @Override
    public EstateFeature findByName(String feature) {
        return estateFeatureRepository.findByFeature(feature)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Feature with name %s does not exists", feature)));
    }
}
