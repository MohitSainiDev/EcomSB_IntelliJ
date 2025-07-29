package com.ecommerce.project.Controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryService  categoryService;

    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories() , HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    ResponseEntity<String> createCategory(@RequestBody Category category){

        return new ResponseEntity<>(categoryService.createCategory(category) , HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{CategoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable  Long CategoryId){
        try{
            return new ResponseEntity<>(categoryService.deleteCategory(CategoryId) , HttpStatus.OK);
        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason() , e.getStatusCode());
        }
    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category , @PathVariable Long categoryId){
        try{
            return new ResponseEntity<>(categoryService.updateCategory(category , categoryId) , HttpStatus.OK);
        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason() , e.getStatusCode());
        }
    }


}
