package org.gymapp.membershipservice;

import org.gymapp.membershipservice.entity.CategoryRef;
import org.gymapp.membershipservice.repository.CategoryRefRepository;
import org.gymapp.membershipservice.service.CategoryRefService;
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
    private CategoryRefRepository categoryRepository;

    @InjectMocks
    private CategoryRefService categoryService;

    @Test
    void testSavedCategoryRef(){
        //arrange
        CategoryRef category = new CategoryRef();
        CategoryRef savedCategoryRef = new CategoryRef();

        when(categoryRepository.save(category)).thenReturn(savedCategoryRef);

        //act
        CategoryRef result = categoryService.save(category);

        //assert
        //check if save was done
        assertEquals(savedCategoryRef, result);
        //check if save was done once
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void testReturnAllCategoryRefs(){
        //arrange
        List<CategoryRef> categories= List.of(new CategoryRef(), new CategoryRef());

        when(categoryRepository.findAll()).thenReturn(categories);

        //act
        List<CategoryRef> results = categoryService.findAll();

        //assert
        //check if returned list contain 2 elements
        assertEquals(2, results.size());
        //check if findAll was triggered once
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void testDeleteCategoryRef(){
        //arrange
        CategoryRef categories = new CategoryRef();

        //act
        categoryService.delete(categories);

        //assert
        //check if delete was triggered once
        verify(categoryRepository, times(1)).delete(categories);
    }
}
