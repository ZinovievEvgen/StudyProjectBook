package exec.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-DimGenre: содержит информацию о жанрах книг
 */
@Entity
@Table(name = "dimGenre")
public class DimGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private long idOfDimGenre;

    @Column(name = "genreName", nullable = false)
    private String genreName;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Book.class)
    @JoinTable(name = "bookGenreLnk",
            joinColumns = {@JoinColumn(name = "genre_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    @JsonBackReference
    private List<Book> books;

    public DimGenre() {
    }

    public DimGenre(String genreName) {
        this.genreName = genreName;
    }

    public long getIdOfDimGenre() {
        return idOfDimGenre;
    }

    public void setIdOfDimGenre(long idOfDimGenre) {
        this.idOfDimGenre = idOfDimGenre;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
