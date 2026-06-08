package org.gymapp.memberservice.service;

import lombok.AllArgsConstructor;
import org.gymapp.memberservice.entity.Category;
import org.gymapp.memberservice.repository.CategoryRepository;
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

    public Optional<Category> findById(UUID id) {return categoryRepository.findById(id); }

    public void delete(Category category) { categoryRepository.delete(category); }
}
