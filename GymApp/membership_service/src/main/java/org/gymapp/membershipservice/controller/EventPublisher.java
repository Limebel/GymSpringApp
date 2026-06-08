package org.gymapp.membershipservice.controller;

import lombok.RequiredArgsConstructor;
import org.gymapp.membershipservice.dto.event.PublishedEventDto;
import org.gymapp.membershipservice.entity.Membership;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class EventPublisher {
    private final RestTemplate restTemplate;

    @Value("${member-service.url}")
    private String elementServiceUrl;

    public void membershipCreated(Membership membership) {
        PublishedEventDto dto = new PublishedEventDto(
                membership.getId(),
                membership.getName(),
                membership.getMaxMembers()
        );

        restTemplate.postForEntity(
                elementServiceUrl + "/events/memberships",
                dto,
                Void.class
        );
    }
}
