package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final List<Category> categories = new ArrayList<>();
    private Long id = 0L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public String createCategory(Category category) {
        category.setCategoryId(++id);
        categories.add(category);
        return "category created successfully";
    }

    @Override
    public String deleteCategory(Long CategoryId) {
        Category category = categories.stream().filter(c -> c.getCategoryId().equals(CategoryId)).findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND , "Not Found"));
        categories.remove(category);
            return "category with category id " + CategoryId + " deleted successfully";


    }

    @Override
    public String updateCategory(Category category , Long CategoryId) {
        Category category1 = categories.stream().filter(c->c.getCategoryId().equals(CategoryId)).findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND , "Not Found"));
        category1.setCategoryName(category.getCategoryName());
        return "category with category id " + CategoryId + " updated successfully";
    }

}
