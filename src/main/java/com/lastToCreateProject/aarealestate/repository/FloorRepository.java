package com.lastToCreateProject.aarealestate.repository;

import com.lastToCreateProject.aarealestate.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Long> {
    Optional<Floor> findByNumber(Integer number);
}
