package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.dto.CategoryRequest;
import com.tradeconnect.tradeconnectapi.dto.CategoryResponse;
import com.tradeconnect.tradeconnectapi.model.Category;
import com.tradeconnect.tradeconnectapi.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public String addCategory(CategoryRequest categoryRequest) {
        Category category = Category.builder()
                .name(categoryRequest.name())
                .description(categoryRequest.description())
                .build();
        categoryRepository.save(category);
        return "Category added successfully";
    }

    public List<CategoryResponse> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(this::mapToCategoryResponse)
                .collect(Collectors.toList());
    }

    // map Category to CategoryResponse
    private CategoryResponse mapToCategoryResponse(Category category) {
        return new CategoryResponse(category.getId(), category.getName(), category.getDescription());
    }

    // get category by id
    public CategoryResponse getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return mapToCategoryResponse(category);
    }
}
