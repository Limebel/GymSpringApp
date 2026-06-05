package org.gymapp.membershipservice;

import org.gymapp.membershipservice.entity.Category;
import org.gymapp.membershipservice.repository.CategoryRepository;
import org.gymapp.membershipservice.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void testSavedCategoryRef(){
        //arrange
        Category category = new Category("street");
        Category savedCategory = new Category("street");

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
    void testReturnAllCategoryRefs(){
        //arrange
        List<Category> categories= List.of(new Category("street"), new Category("street"));

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
    void testDeleteCategoryRef(){
        //arrange
        Category categories = new Category("street");

        //act
        categoryService.delete(categories);

        //assert
        //check if delete was triggered once
        verify(categoryRepository, times(1)).delete(categories);
    }
}
