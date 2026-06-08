package org.gymapp.membershipservice.service;

import lombok.AllArgsConstructor;
import org.gymapp.membershipservice.entity.Category;
import org.gymapp.membershipservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category save(Category category){ return categoryRepository.save(category); }

    public List<Category> findAll() {return categoryRepository.findAll(); }

    public Optional<Category> findById(UUID id) {return categoryRepository.findById(id);}

    public void delete(Category category) { categoryRepository.delete(category); }
}
