package com.ecommerce.project.Controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService  categoryService;

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    String createCategory(@RequestBody Category category){

        return categoryService.createCategory(category);
    }

    @DeleteMapping("/api/admin/categories/{CategoryId}")
    public String deleteCategory(@PathVariable  Long CategoryId){
        return categoryService.deleteCategory(CategoryId);
    }


}
