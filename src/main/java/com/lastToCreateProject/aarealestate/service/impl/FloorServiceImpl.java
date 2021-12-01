package com.lastToCreateProject.aarealestate.service.impl;

import com.lastToCreateProject.aarealestate.exceptions.DuplicateRecordException;
import com.lastToCreateProject.aarealestate.exceptions.ResourceNotFoundException;
import com.lastToCreateProject.aarealestate.model.Floor;
import com.lastToCreateProject.aarealestate.repository.FloorRepository;
import com.lastToCreateProject.aarealestate.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FloorServiceImpl implements FloorService {

    private final FloorRepository floorRepository;

    @Autowired
    public FloorServiceImpl(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    @Override
    public Set<Floor> findAll() {
        return new HashSet<>(floorRepository.findAll());
    }

    @Override
    public Floor save(Floor floor) {
        try {
            return floorRepository.save(floor);
        } catch (DataIntegrityViolationException exception) {
            throw new DuplicateRecordException(String.format("Floor with number %d already exists", floor.getNumber()));
        }
    }

    @Override
    public Floor findByNumber(Integer number) {
        return floorRepository.findByNumber(number).
                orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Floor %d does not exist", number)));
    }

    @Override
    public Floor findById(Long id) {
        return floorRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Floor with ID %d does not exist", id)));
    }

    @Override
    public Floor update(Floor floor, Long id) {
        Floor foundFloor = findById(id);
        Floor updatedFloor = Floor.builder()
                .id(foundFloor.getId())
                .number(floor.getNumber())
                .build();

        return save(updatedFloor);
    }

    @Override
    public void delete(Long id) {
        floorRepository.deleteById(id);

    }

}
