package app.prog.controller.mapper;

import app.prog.controller.response.AuthorRequest;
import app.prog.controller.response.AuthorResponse;
import app.prog.model.AuthorEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public AuthorResponse toRest(AuthorEntity author){
        return AuthorResponse.builder()
                .id(author.getId())
                .name(author.getName())
                .particularity(author.getParticularity())
                .hasParticularity(author.hasParticularity())
                .build();
    }
    public AuthorEntity toDomain(AuthorRequest authorRequest){
        return AuthorEntity.builder()
                .name(authorRequest.getName())
                .particularity(authorRequest.getParticularity())
                .build();
    }
}
