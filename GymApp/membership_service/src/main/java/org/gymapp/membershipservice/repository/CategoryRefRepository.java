package org.gymapp.membershipservice.repository;

import org.gymapp.membershipservice.entity.CategoryRef;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRefRepository extends JpaRepository<CategoryRef, UUID> {
}
