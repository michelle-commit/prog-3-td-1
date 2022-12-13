package app.prog.service;

import app.prog.controller.mapper.AuthorMapper;
import app.prog.model.AuthorEntity;
import app.prog.model.CategoryEntity;
import app.prog.repository.AuthorRepository;
import app.prog.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    public List<CategoryEntity> getCategory() {
        return categoryRepository.findAll();
    }

    public List<CategoryEntity> createCategory(List<CategoryEntity> toCreate) {
        return categoryRepository.saveAll(toCreate);
    }

    public List<CategoryEntity> updateCategory(List<CategoryEntity> toUpdate) {
        return categoryRepository.saveAll(toUpdate);
    }
}
