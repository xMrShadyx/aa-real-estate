package com.lastToCreateProject.aarealestate.service.impl;

import com.lastToCreateProject.aarealestate.exceptions.ResourceNotFoundException;
import com.lastToCreateProject.aarealestate.model.Neighborhood;
import com.lastToCreateProject.aarealestate.repository.NeighborhoodRepository;
import com.lastToCreateProject.aarealestate.service.NeighborhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class NeighborhoodServiceImpl implements NeighborhoodService {

    private final NeighborhoodRepository neighborhoodRepository;

    @Autowired
    public NeighborhoodServiceImpl(NeighborhoodRepository neighborhoodRepository) {
        this.neighborhoodRepository = neighborhoodRepository;
    }

    @Override
    public Neighborhood findByName(String name) {
        return neighborhoodRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Neighborhood with %s name not exists", name)));
    }

    @Override
    public Neighborhood findById(Long id) {
        return neighborhoodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Neighborhood with %s id not exists", id)));
    }

    @Override
    public Set<Neighborhood> findAll() {
        return new HashSet<>(neighborhoodRepository.findAll());
    }

    @Override
    public Neighborhood save(Neighborhood neighborhood) {
        return neighborhoodRepository.save(neighborhood);
    }
}
