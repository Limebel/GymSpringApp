package org.gymapp.membershipservice.repository;

import org.gymapp.membershipservice.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MembershipRepository extends JpaRepository<Membership, UUID> {
}
