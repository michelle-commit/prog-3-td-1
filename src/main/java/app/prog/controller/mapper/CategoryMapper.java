package app.prog.controller.mapper;

import app.prog.controller.response.CategoryResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.CreateCategoryResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.BookEntity;
import app.prog.model.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryResponse toRest(CategoryEntity categoryEntity){
        return CategoryResponse.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .build();
    }
    public CategoryEntity toDomain( CreateCategoryResponse rest) {
        return CategoryEntity.builder()
                .name(rest.getName())
                .build();
    }

    public CategoryEntity toDomain(CategoryResponse rest) {
        return CategoryEntity.builder()
                .id(rest.getId())
                .name(rest.getName())
                .build();
    }
}
