package org.gymapp.membershipservice;

import org.gymapp.membershipservice.entity.Category;
import org.gymapp.membershipservice.entity.Membership;
import org.gymapp.membershipservice.entity.MembershipType;
import org.gymapp.membershipservice.entity.Price;
import org.gymapp.membershipservice.repository.CategoryRepository;
import org.gymapp.membershipservice.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void testSavedCategory(){
        //arrange
        Category category = new Category(UUID.randomUUID(), "street");
        Category savedCategory = new Category(UUID.randomUUID(), "street");

        when(categoryRepository.save(category)).thenReturn(savedCategory);

        //act
        Category result = categoryService.save(category);

        //assert
        //check if save was done
        assertEquals(savedCategory, result);
        //check if save was done once
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void testFindAllCategories(){
        //arrange
        List<Category> categories= List.of(new Category(UUID.randomUUID(), "street"), new Category(UUID.randomUUID(), "street"));

        when(categoryRepository.findAll()).thenReturn(categories);

        //act
        List<Category> results = categoryService.findAll();

        //assert
        //check if returned list contain 2 elements
        assertEquals(2, results.size());
        //check if findAll was triggered once
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void testFindExistingCategory() {
        // arrange
        UUID id = UUID.randomUUID();
        Category category = new Category(id, "street");

        when(categoryRepository.findById(id))
                .thenReturn(Optional.of(category));

        // act
        Optional<Category> result = categoryService.findById(id);

        // assert
        //check if value was returned with the same id
        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
        //check if findById was triggered once
        verify(categoryRepository, times(1)).findById(id);
    }

    @Test
    void testFindNonExistingCategory() {
        // arrange
        UUID id = UUID.randomUUID();

        when(categoryRepository.findById(id))
                .thenReturn(Optional.empty());

        // act
        Optional<Category> result = categoryService.findById(id);

        // assert
        //check if returned value is empty
        assertTrue(result.isEmpty());
        //check if findById was triggered once
        verify(categoryRepository, times(1)).findById(id);
    }

    @Test
    void testDeleteCategory(){
        //arrange
        Category categories = new Category(UUID.randomUUID(), "street");

        //act
        categoryService.delete(categories);

        //assert
        //check if delete was triggered once
        verify(categoryRepository, times(1)).delete(categories);
    }
}
