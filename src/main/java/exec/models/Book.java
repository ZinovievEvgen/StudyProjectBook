package exec.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-Book: содержит информацию о книгах
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long idOfBook;

    @NotNull
    @Column(name = "name_of_book")
    private String nameOfBook;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_genre_lnk",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<DimGenre> genres = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_of_person")
    @JsonBackReference(value = "person-book")
    private Person person;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_of_author")
    @JsonBackReference(value = "author-book")
    private Author authorOfBook;

    public Book() {
    }

    public Book(@NotNull Author authorOfBook, @NotNull String nameOfBook) {
        this.authorOfBook = authorOfBook;
        this.nameOfBook = nameOfBook;
    }

    public Long getIdOfBook() {
        return idOfBook;
    }

    public void setIdOfBook(Long idOfBook) {
        this.idOfBook = idOfBook;
    }

    public Author getAuthorOfBook() {
        return authorOfBook;
    }

    public void setAuthorOfBook(Author authorOfBook) {
        this.authorOfBook = authorOfBook;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<DimGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<DimGenre> genres) {
        this.genres = genres;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }
}
