package app.prog.service;

import app.prog.controller.mapper.AuthorMapper;
import app.prog.controller.response.AuthorRequest;
import app.prog.controller.response.AuthorResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {
    @Autowired
    private final AuthorRepository authorRepository;
    @Autowired
    private final AuthorMapper authorMapper;


    public List<AuthorEntity> getAuthor() {
        return authorRepository.findAll();
    }

    public List<AuthorEntity> createBooks(List<AuthorEntity> toCreate) {
        return authorRepository.saveAll(toCreate);
    }

    public List<AuthorEntity> updateBooks(List<AuthorEntity> toUpdate) {
        return authorRepository.saveAll(toUpdate);
    }
}
