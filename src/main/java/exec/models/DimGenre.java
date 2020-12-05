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
public class DimGenre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long idOfDimGenre;

    @NotNull
    @Column(name = "genre_name")
    private String genreName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_genre_lnk",
            joinColumns = {@JoinColumn(name = "genre_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    @JsonBackReference(value = "genre-book")
    private List<Book> books;

    @Formula("(SELECT COUNT(*) FROM book_genre_lnk bg WHERE bg.genre_id = id_of_dim_genre GROUP BY id_of_dim_genre)")
    private Long countOfBook;

    public DimGenre() {
    }

    public DimGenre(@NotNull String genreName) {
        this.genreName = genreName;
    }

    public Long getIdOfDimGenre() {
        return idOfDimGenre;
    }

    public void setIdOfDimGenre(Long idOfDimGenre) {
        this.idOfDimGenre = idOfDimGenre;
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

    public Long getCountOfBook() {
        return countOfBook;
    }

    public void setCountOfBook(Long countOfBook) {
        this.countOfBook = countOfBook;
    }

    @Override
    public String toString() {
        return "DimGenre{" +
                "genreName='" + genreName + '\'' +
                '}';
    }
}
