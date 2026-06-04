package org.gymapp.membershipservice.service;

import lombok.AllArgsConstructor;
import org.gymapp.membershipservice.entity.CategoryRef;
import org.gymapp.membershipservice.entity.Membership;
import org.gymapp.membershipservice.repository.CategoryRefRepository;
import org.gymapp.membershipservice.repository.MembershipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryRefService {
    private final CategoryRefRepository categoryRepository;

    public CategoryRef save(CategoryRef category){ return categoryRepository.save(category); }

    public List<CategoryRef> findAll() {return categoryRepository.findAll(); }

    public void delete(CategoryRef category) { categoryRepository.delete(category); }
}
