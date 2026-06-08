package org.gymapp.membershipservice.service;

import lombok.AllArgsConstructor;
import org.gymapp.membershipservice.entity.Membership;
import org.gymapp.membershipservice.repository.MembershipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MembershipService {
    private final MembershipRepository membershipRepository;

    public Membership save(Membership membership){ return membershipRepository.save(membership); }

    public List<Membership> findAll() {return membershipRepository.findAll(); }

    public Optional<Membership> findById(UUID id) {return membershipRepository.findById(id); }

    public void delete(Membership membership) { membershipRepository.delete(membership); }
}
