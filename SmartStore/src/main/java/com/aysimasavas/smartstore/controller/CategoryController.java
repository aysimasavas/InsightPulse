package com.aysimasavas.smartstore.controller;

import com.aysimasavas.smartstore.dto.CategoryRequest;
import com.aysimasavas.smartstore.dto.CategoryResponse;
import com.aysimasavas.smartstore.dto.ProductRequest;
import com.aysimasavas.smartstore.dto.ProductResponse;
import com.aysimasavas.smartstore.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    private CategoryResponse createCategory(@RequestBody CategoryRequest request) {
        return categoryService.createCategory(request);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    private List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private CategoryResponse getCategoryById(@PathVariable String id) {
        return categoryService.getCategoryById(id);
    }
}
