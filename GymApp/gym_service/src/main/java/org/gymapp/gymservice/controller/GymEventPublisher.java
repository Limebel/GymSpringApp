package org.gymapp.gymservice.controller;

import lombok.RequiredArgsConstructor;
import org.gymapp.gymservice.dto.event.PublishedEventDto;
import org.gymapp.gymservice.entity.Gym;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class GymEventPublisher {
    private final RestTemplate restTemplate;

    @Value("${membership-service.url}")
    private String elementServiceUrl;

    public void categoryCreated(Gym gym) {
        PublishedEventDto dto = new PublishedEventDto(
                gym.getId(),
                gym.getAddress()
        );

        restTemplate.postForEntity(
                elementServiceUrl + "/events/gyms",
                dto,
                Void.class
        );
    }
}
