package com.aysimasavas.smartstore.service;

import com.aysimasavas.smartstore.dto.CategoryRequest;
import com.aysimasavas.smartstore.dto.CategoryResponse;
import com.aysimasavas.smartstore.entity.Category;
import com.aysimasavas.smartstore.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponse createCategory(CategoryRequest resquest){
        Category category=resquest.mapToCategory();
        Category savedCategory=categoryRepository.save(category);
        return CategoryResponse.mapCategory(savedCategory);
    }

    public List<CategoryResponse> getAllCategories(){
        List<Category> categories=categoryRepository.findAll();
        return categories.stream().map(CategoryResponse::mapCategory).toList();
    }

    public CategoryResponse getCategoryById(String id){
        Optional<Category> category=categoryRepository.findById(id);
        return CategoryResponse.mapCategory(category.get());
    }

}
