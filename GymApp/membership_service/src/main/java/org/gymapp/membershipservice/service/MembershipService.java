package org.gymapp.membershipservice.service;

import lombok.AllArgsConstructor;
import org.gymapp.membershipservice.entity.Membership;
import org.gymapp.membershipservice.entity.MembershipType;
import org.gymapp.membershipservice.repository.MembershipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MembershipService {
    private final MembershipRepository gymRepository;

    public Membership save(Membership membership){ return gymRepository.save(membership); }

    public List<Membership> findAll() {return gymRepository.findAll(); }

    public void delete(Membership membership) { gymRepository.delete(membership); }
}
