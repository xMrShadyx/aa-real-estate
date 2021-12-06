package com.lastToCreateProject.aarealestate.service;

import com.lastToCreateProject.aarealestate.model.Neighborhood;

import java.util.Set;

public interface NeighborhoodService {

    Neighborhood findByName(String name);

    Neighborhood findById(Long id);

    Set<Neighborhood> findAll();

    Neighborhood save(Neighborhood neighborhood);

}
