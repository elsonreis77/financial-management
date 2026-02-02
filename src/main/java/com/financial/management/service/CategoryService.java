package com.financial.management.service;

import com.financial.management.domain.model.Category;
import com.financial.management.dto.request.CategoryRequest;
import com.financial.management.dto.response.CategoryResponse;
import com.financial.management.repository.CategoryRepository;
import com.financial.management.utilities.TextUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public CategoryResponse createCategory(CategoryRequest categoryRequest) {

        Category categoryEntity = new Category();

        String normalizedName = TextUtils.normalize(categoryRequest.getName());

        if (repository.existsByNormalizedName(normalizedName)){
            throw new RuntimeException("Nome já existe.");
        }

        categoryEntity.setName(categoryRequest.getName().trim());
        categoryEntity.setNormalizedName(normalizedName);
        categoryEntity.setCategoryType(categoryRequest.getCategoryType());

        repository.save(categoryEntity);

        return toResponse(categoryEntity);
    }

    public List<CategoryResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public CategoryResponse findById(Long id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
        return toResponse(category);
    }

    public CategoryResponse updateCategory(Long id, CategoryRequest request) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        if (request.getName().isEmpty()){
            category.setCategoryType(request.getCategoryType());
        } else {
            category.setName(request.getName());
            category.setCategoryType(request.getCategoryType());
        }

        repository.save(category);

        return toResponse(category);
    }

    public String deleteCategory(Long id) {
        if (repository.existsById(id)) {
            Optional<Category> category = repository.findById(id);
            String categoryName = category.get().getName();
            repository.deleteById(id);
            return categoryName;
        } else {
            throw new EntityNotFoundException("Categoria não encontrada!");
        }
    }

    private CategoryResponse toResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setName(category.getName());
        response.setCategoryType(category.getCategoryType());
        return response;
    }

}
