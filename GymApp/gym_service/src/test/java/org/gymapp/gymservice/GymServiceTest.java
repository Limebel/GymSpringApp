package org.gymapp.gymservice;

import org.gymapp.gymservice.entity.Gym;
import org.gymapp.gymservice.repository.GymRepository;
import org.gymapp.gymservice.service.GymService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GymServiceTest{
    @Mock
    private GymRepository gymRepository;

    @InjectMocks
    private GymService gymService;

    @Test
    void testSavedGym(){
        //arrange
        Gym gym = Gym.builder()
                .address("street")
                .phoneNumber("000-000-000")
                .build();
        Gym savedGym = Gym.builder()
                .address("street")
                .phoneNumber("000-000-000")
                .build();

        when(gymRepository.save(gym)).thenReturn(savedGym);

        //act
        Gym result = gymService.save(gym);

        //assert
        //check if save was done
        assertEquals(savedGym, result);
        //check if save was done once
        verify(gymRepository, times(1)).save(gym);
    }

    @Test
    void testFindAllGyms(){
        //arrange
        List<Gym> gyms= List.of(
                Gym.builder()
                        .address("street")
                        .phoneNumber("000-000-000")
                        .build(),
                Gym.builder()
                        .address("street")
                        .phoneNumber("000-000-000")
                        .build());

        when(gymRepository.findAll()).thenReturn(gyms);

        //act
        List<Gym> results = gymService.findAll();

        //assert
        //check if returned list contain 2 elements
        assertEquals(2, results.size());
        //check if findAll was triggered once
        verify(gymRepository, times(1)).findAll();
    }

    @Test
    void testDeleteGym(){
        //arrange
        Gym gym = Gym.builder()
                .address("street")
                .phoneNumber("000-000-000")
                .build();

        //act
        gymService.delete(gym);

        //assert
        //check if delete was triggered once
        verify(gymRepository, times(1)).delete(gym);
    }

}
