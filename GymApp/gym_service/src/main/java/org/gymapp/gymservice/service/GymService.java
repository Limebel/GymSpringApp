package org.gymapp.gymservice.service;

import lombok.AllArgsConstructor;
import org.gymapp.gymservice.entity.Gym;
import org.gymapp.gymservice.repository.GymRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GymService {
    private final GymRepository gymRepository;

    public Gym save(Gym gym){ return gymRepository.save(gym); }

    public List<Gym> findAll() {return gymRepository.findAll(); }

    public void delete(Gym gym) { gymRepository.delete(gym); }
}
