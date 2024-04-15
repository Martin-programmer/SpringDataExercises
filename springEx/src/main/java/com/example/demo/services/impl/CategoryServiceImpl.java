package com.example.demo.services.impl;

import com.example.demo.constants.GlobalConstants;
import com.example.demo.entities.Category;
import com.example.demo.repostiroties.CategoryRepository;
import com.example.demo.services.CategoryService;
import com.example.demo.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() != 0){
            return;
        }
        String[] fileContent = fileUtil.readFileContent(GlobalConstants.CATEGORIES_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r -> {
                    categoryRepository.saveAndFlush(new Category(r));
                });
    }

    @Override
    public int categoriesCount() {
        return (int) categoryRepository.count();
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryRepository.findById((long)categoryId).orElseThrow();
    }
}
