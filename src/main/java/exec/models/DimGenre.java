package exec.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-DimGenre: содержит информацию о жанрах книг
 */
@Entity
@Table(name = "dim_genre")
public class DimGenre extends BaseEntityAudit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "genre_name")
    private String genreName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "book_genre_lnk",
            joinColumns = {@JoinColumn(name = "genre_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    @JsonBackReference(value = "genre-book")
    private List<Book> books;

    @Formula("(SELECT COUNT(*) FROM book_genre_lnk bg WHERE bg.genre_id = id GROUP BY id)")
    private Long countOfBook;

    public DimGenre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCountOfBook() {
        return countOfBook;
    }

    public void setCountOfBook(Long countOfBook) {
        this.countOfBook = countOfBook;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return "DimGenre{" +
                "genreName='" + genreName + '\'' +
                '}';
    }
}
