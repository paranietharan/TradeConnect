package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.dto.CategoryRequest;
import com.tradeconnect.tradeconnectapi.dto.CategoryResponse;
import com.tradeconnect.tradeconnectapi.dto.UpdateCategoryRequest;
import com.tradeconnect.tradeconnectapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    // add new category
    @PostMapping
    public ResponseEntity<String> addCategory(
            @RequestBody CategoryRequest categoryRequest
    ) {
        return ResponseEntity.ok(categoryService.addCategory(categoryRequest));
    }

    // get all categories
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    // get category by id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    // update category by id
    @PutMapping
    public ResponseEntity<String> updateCategory(
            @RequestBody UpdateCategoryRequest categoryRequest
    ) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryRequest));
    }
}
