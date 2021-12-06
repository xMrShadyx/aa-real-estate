package com.lastToCreateProject.aarealestate.repository;

import com.lastToCreateProject.aarealestate.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
