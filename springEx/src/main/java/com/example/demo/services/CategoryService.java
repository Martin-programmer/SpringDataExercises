package com.example.demo.services;

import com.example.demo.entities.Category;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;

    int categoriesCount();

    Category getCategoryById(int categoryId);
}
