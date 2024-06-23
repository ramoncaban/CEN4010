package CEN4010.project.book_details.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;
    private String biography;
    private String publisher;

}
