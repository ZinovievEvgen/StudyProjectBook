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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long idOfBook;

    @Column(name = "nameOfBook", nullable = false)
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
    @JoinColumn(name = "idOfAuthor", nullable = false)
    @JsonBackReference
    private Author authorOfBook;

    public Book() {
    }

    public Book(String nameOfBook, Author authorOfBook) {
        this.nameOfBook = nameOfBook;
        this.authorOfBook = authorOfBook;
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
