package com.lastToCreateProject.aarealestate.service.impl;

import com.lastToCreateProject.aarealestate.exceptions.DuplicateRecordException;
import com.lastToCreateProject.aarealestate.exceptions.ResourceNotFoundException;
import com.lastToCreateProject.aarealestate.model.Floor;
import com.lastToCreateProject.aarealestate.repository.FloorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FloorServiceImplTest {

    @Mock
    private FloorRepository floorRepository;

    @InjectMocks
    private FloorServiceImpl floorServiceImpl;

    private Floor floor;

    @Test
    public void verifyFindAll() {
        when(floorRepository.findAll())
                .thenReturn(Collections.emptyList());
        floorServiceImpl.findAll();
        verify(floorRepository, times(1)).findAll();
    }

    @Test
    public void verifySave() {
        Floor build = Floor.builder().build();
        when(floorRepository.save(any(Floor.class)))
                .thenReturn(build);
        floorServiceImpl.save(build);
        verify(floorRepository, times(1)).save(build);
    }

    @Test(expected = DuplicateRecordException.class)
    public void verifySaveDuplicateException() {
        when(floorRepository.save(any(Floor.class))).thenThrow(DataIntegrityViolationException.class);
        floorServiceImpl.save(Floor.builder().build());
    }

    @Test
    public void verifyFindByNumber() {
        when(floorRepository.findByNumber(any(Integer.class)))
                .thenReturn(Optional.of(Floor.builder().build()));
        floorServiceImpl.findByNumber(1);
        verify(floorRepository, times(1)).findByNumber(1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void verifyFindByNumberException() {
        when(floorRepository.findByNumber(any(Integer.class)))
                .thenReturn(Optional.empty());

        floorServiceImpl.findByNumber(1);
    }

    @Test
    public void verifyFindById() {
        when(floorRepository.findById(any(Long.class)))
                .thenReturn(Optional.of(Floor.builder().build()));
        floorServiceImpl.findById(1L);
        verify(floorRepository, times(1)).findById(1L);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void verifyFindByIdException() {
        when(floorRepository.findById(any(Long.class)))
                .thenReturn(Optional.empty());

        floorServiceImpl.findById(1L);
    }

    @Test
    public void verifyDelete() {
        doNothing().when(floorRepository).deleteById(any(Long.class));
        floorServiceImpl.delete(1L);
        verify(floorRepository, times(1)).deleteById(1L);
    }
}
