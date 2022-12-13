package app.prog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {
    @Id
    private long id;
    private String name;
    private String particularity;

    public boolean hasParticularity() {
        return particularity != null;
    }
}