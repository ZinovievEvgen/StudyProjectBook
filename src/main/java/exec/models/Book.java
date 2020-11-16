package exec.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-Book: содержит информацию о книгах
 */
@Entity
@Table(name = "book")
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long idOfBook;

    @Column(name = "nameOfBook")
    private String nameOfBook;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "bookGenreLnk",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<DimGenre> genres = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOfPerson")
    @JsonBackReference
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOfAuthor")
    @JsonBackReference
    private Author authorOfBook;

    public Book() {
    }
}
