package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Category findCategoriesByCategoryId(Integer categoryId);
    Category findCategoriesByName(String name);
}
