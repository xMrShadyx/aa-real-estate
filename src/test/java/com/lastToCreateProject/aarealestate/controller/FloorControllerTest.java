package com.lastToCreateProject.aarealestate.controller;

import com.lastToCreateProject.aarealestate.converter.FloorConverter;
import com.lastToCreateProject.aarealestate.dto.FloorDto;
import com.lastToCreateProject.aarealestate.model.Floor;
import com.lastToCreateProject.aarealestate.service.FloorService;

import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(value = FloorController.class)
public class FloorControllerTest extends BaseControllerTest {

    @MockBean
    private FloorService floorService;

    @MockBean
    private FloorConverter floorConverter;

    @Test
    public void save() throws Exception {
        FloorDto floorDto = FloorDto.builder().number(1).build();
        String requestJson = objectMapper.writeValueAsString(floorDto);

        when(floorConverter.toFloor(any(FloorDto.class))).thenReturn(Floor.builder().build());
        when(floorService.save(any(Floor.class))).thenReturn(Floor.builder().build());
        when(floorConverter.toFloorDto(any(Floor.class))).thenReturn(FloorDto.builder().id(1L).number(1).build());

        mockMvc.perform(MockMvcRequestBuilders.post("/floors")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )

                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.number", is(1)));

    }

    @Test
    public void update() throws Exception {
        FloorDto floorDto = FloorDto.builder().id(1L).number(2).build();
        String requestJson = objectMapper.writeValueAsString(floorDto);

        when(floorConverter.toFloorDto(any())).thenReturn(floorDto);

        mockMvc.perform(put("/floors/1")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.number", is(2)));
    }

    @Test
    public void findById() throws Exception {
        when(floorService.findById(any(Long.class))).thenReturn(Floor.builder().build());
        when(floorConverter.toFloorDto(any(Floor.class))).thenReturn(FloorDto.builder().id(1L).number(5).build());

        mockMvc.perform(MockMvcRequestBuilders.get("/floor/id/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.number", is(5)));
    }

    @Test
    public void deleteTest() throws Exception {
        mockMvc.perform(delete("/floors/1"))
                .andExpect(status().isOk());
    }


}