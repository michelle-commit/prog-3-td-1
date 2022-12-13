package app.prog.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}
