package com.example.blogsystem.Service;

import com.example.blogsystem.ApiResponse.ApiException;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Repository.CategoryRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(Integer categoryId,Category category ){
        Category oldCategory=categoryRepository.findCategoriesByCategoryId(categoryId);

        if(oldCategory==null){
            throw new ApiException("category not found");
        }

        oldCategory.setName(category.getName());
        categoryRepository.save(oldCategory);
    }

    public void deleteCategory(Integer categoryId){
        Category category=categoryRepository.findCategoriesByCategoryId(categoryId);
        if(category==null){
            throw new ApiException("category not found");
        }
        categoryRepository.delete(category);

    }

    //5
    public Category findCategoryByName(String name){
        Category category=categoryRepository.findCategoriesByName(name);
        if(category==null){
            throw new ApiException("category not found");
        }
        return category;
    }
}
