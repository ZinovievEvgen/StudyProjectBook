package exec.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import liquibase.pro.packaged.B;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-Book: содержит информацию о книгах
 */
@Entity
@Table(name = "book")
public class Book extends BaseEntityAudit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @CreatedDate
    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "edition_date")
    private LocalDate editionDate;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_genre_lnk",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<DimGenre> genres;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_of_author")
    @JsonBackReference(value = "author-book")
    private Author authorOfBook;

    @OneToMany(mappedBy = "book")
    @JsonBackReference
    private List<LibraryCard> libraryCards;

    public Book() {
    }

    public Book(@NotNull Author authorOfBook, @NotNull String name) {
        this.authorOfBook = authorOfBook;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthorOfBook() {
        return authorOfBook;
    }

    public void setAuthorOfBook(Author authorOfBook) {
        this.authorOfBook = authorOfBook;
    }

    public List<DimGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<DimGenre> genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(LocalDate editionDate) {
        this.editionDate = editionDate;
    }

    public List<LibraryCard> getLibraryCards() {
        return libraryCards;
    }

    public void setLibraryCards(List<LibraryCard> libraryCards) {
        this.libraryCards = libraryCards;
    }
}
