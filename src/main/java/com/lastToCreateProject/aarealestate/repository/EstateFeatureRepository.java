package com.lastToCreateProject.aarealestate.repository;

import com.lastToCreateProject.aarealestate.model.EstateFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstateFeatureRepository extends JpaRepository<EstateFeature, Long> {

    Optional<EstateFeature> findByFeature(String feature);
}
