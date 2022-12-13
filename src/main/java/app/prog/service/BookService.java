package app.prog.service;

import app.prog.controller.mapper.BookRestMapper;
import app.prog.controller.response.BookResponse;
import app.prog.model.BookEntity;
import app.prog.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository repository;
    @Autowired
    private final BookRestMapper bookRestMapper

    public List<BookEntity> getBooks() {
        return repository.findAll();
    }
    public List<BookResponse> getBookResponses() {

        List<BookEntity> entities = repository.findAll();
        List<BookResponse> responses = new ArrayList<>();
        for(int i = 0; i < entities.size(); i++) {
            responses.add(BookResponse.builder()
                            .id(entities.get(i).getId())
                    .build());
        }
    }
    public List<BookResponse> getBookResponses() {

        List<BookEntity> entities = repository.findAll();
        List<BookResponse> responses = bookRestMapper.toRest(List<BookEntity> books);
    }

    public List<BookEntity> createBooks(List<BookEntity> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<BookEntity> updateBooks(List<BookEntity> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    //TODO-3: should I use Integer here or int ? Why ?
    public BookEntity deleteBook(int BookEntityId) {
        /*
        TIPS: From the API, the Class Optional<T> is :
        A container object which may or may not contain a non-null value.
        If a value is present, isPresent() returns true.
        If no value is present, the object is considered empty and isPresent() returns false.

        T is the type of the value, for example : here the class type is BookEntity
         */
        Optional<BookEntity> optional = repository.findById(String.valueOf(BookEntityId));
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        }
        /*
        TODO-5 : The exception appears as an internal server error, status 500.
        We all know that the appropriate error status is the 404 Not Found.
        Any solution to do this ?
        These links may help you :
        Link 1 : https://www.baeldung.com/spring-response-entity
        Link 2 : https://www.baeldung.com/exception-handling-for-rest-with-spring
         */
        throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Resource not found",null);
    }
}
