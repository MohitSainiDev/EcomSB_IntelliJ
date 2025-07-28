package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import org.springframework.stereotype.Service;

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
        Category category = categories.stream().filter(c -> c.getCategoryId().equals(CategoryId)).findFirst().orElse(null);
        if(category!=null)
        {
            categories.remove(category);
            return "category with category id " + CategoryId + " deleted successfully";
        }
        else
            return  "category with category id " + CategoryId + " not found";
    }

}
