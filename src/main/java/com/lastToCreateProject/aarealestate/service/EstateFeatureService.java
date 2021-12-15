package com.lastToCreateProject.aarealestate.service;

import com.lastToCreateProject.aarealestate.model.EstateFeature;

public interface EstateFeatureService {

    EstateFeature save(EstateFeature estateFeature);

    EstateFeature findByName(String feature);

    EstateFeature findById(Long id);


}
