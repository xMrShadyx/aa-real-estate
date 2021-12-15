package com.lastToCreateProject.aarealestate.service;

import com.lastToCreateProject.aarealestate.model.Estate;

import java.util.Set;

public interface EstateService {
    Estate save(Estate estate);

    Set<Estate> findAll();
}
