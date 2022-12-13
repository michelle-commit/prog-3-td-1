package app.prog.controller;

import app.prog.controller.mapper.AuthorMapper;
import app.prog.controller.response.*;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorController {
    @Autowired
    private final AuthorService authorService;
    @Autowired
    private final AuthorMapper authorMapper;
    @GetMapping("/author")
    public List<AuthorResponse> getAuthor() {
        return authorService.getAuthor().stream()
                .map(authorMapper::toRest)
                .toList();
    }

    @PostMapping("/author")
    public List<AuthorResponse> createBooks(@RequestBody List<AuthorRequest> toCreate) {
        List<AuthorEntity> domain = toCreate.stream()
                .map(authorMapper::toDomain)
                .toList();
        return authorService.createBooks(domain).stream()
                .map(authorMapper::toRest)
                .toList();
    }

    @PutMapping("/author")
    public List<AuthorResponse> updateAuthor(@RequestBody List<AuthorRequest> toUpdate) {
        List<AuthorEntity> domain = toUpdate.stream()
                .map(authorMapper::toDomain)
                .toList();
        return authorService.updateBooks(domain).stream()
                .map(authorMapper::toRest)
                .toList();
    }
}
