package app.prog.controller;

import app.prog.controller.mapper.CategoryMapper;
import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CategoryResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.BookEntity;
import app.prog.model.CategoryEntity;
import app.prog.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;
    @Autowired
    private final CategoryMapper categoryMapper;
    @GetMapping("/category")
    public List<CategoryResponse> getCategory() {
        return categoryService.getCategory().stream()
                .map(categoryMapper::toRest)
                .toList();
    }

    @PostMapping("/cathegory")
    public List<CategoryResponse> createCategory(@RequestBody List<CategoryResponse> toCreate) {
        List<CategoryEntity> domain = toCreate.stream()
                .map(categoryMapper::toDomain)
                .toList();
        return categoryService.createCategory(domain).stream()
                .map(categoryMapper::toRest)
                .toList();
    }

    @PutMapping("/category")
    public List<CategoryResponse> updateCategory(@RequestBody List<CategoryResponse> toUpdate) {
        List<CategoryEntity> domain = toUpdate.stream()
                .map(categoryMapper::toDomain)
                .toList();
        return categoryService.updateCategory(domain).stream()
                .map(categoryMapper::toRest)
                .toList();
    }
}
