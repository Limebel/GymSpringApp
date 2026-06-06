package org.gymapp.gymservice.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.gymapp.gymservice.dto.event.CategoryEventDto;
import org.gymapp.gymservice.entity.Gym;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
class CategoryEventPublisher {
    private final RestTemplate restTemplate;

    @Value("${membership-service.url}")
    private String elementServiceUrl;

    public void categoryCreated(Gym category) {
        CategoryEventDto dto = new CategoryEventDto(
                category.getId(),
                category.getAddress()
        );

        restTemplate.postForEntity(
                elementServiceUrl + "/events/gyms",
                dto,
                Void.class
        );
    }
}
