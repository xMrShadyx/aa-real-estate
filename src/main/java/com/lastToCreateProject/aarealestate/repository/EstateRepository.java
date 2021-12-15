package com.lastToCreateProject.aarealestate.repository;

import com.lastToCreateProject.aarealestate.model.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstateRepository extends JpaRepository<Estate, Long> {
}
