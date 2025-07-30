package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

//    private final List<Category> categories = new ArrayList<>();
//    private Long id = 0L;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public String createCategory(Category category) {
        categoryRepository.save(category);
        return "category created successfully";
    }

    @Override
    public String deleteCategory(Long CategoryId) {



        Optional<Category> savedCategoryOptional = categoryRepository.findById(CategoryId);
        Category savedCategory = savedCategoryOptional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND , "Not Found"));
        categoryRepository.delete(savedCategory);
            return "category with category id " + CategoryId + " deleted successfully";


    }

    @Override
    public String updateCategory(Category category , Long CategoryId) {
        Optional<Category> savedCategoryOptional = categoryRepository.findById(CategoryId);
        Category savedCategory = savedCategoryOptional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND , "Not Found"));

        savedCategory.setCategoryName(category.getCategoryName());
        categoryRepository.save(savedCategory);
        return "category with category id " + CategoryId + " updated successfully";
    }

}
