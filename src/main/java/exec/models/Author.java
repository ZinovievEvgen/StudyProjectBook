package exec.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-Author: содержит информацию об авторах книг
 */
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long idOfAuthor;

    @Column(name = "firstNameOfAuthor", nullable = false)
    private String firstNameOfAuthor;

    @Column(name = "lastNameOfAuthor", nullable = false)
    private String lastNameOfAuthor;

    @Column(name = "middleNameOfAuthor")
    private String middleNameOfAuthor;

    @OneToMany(mappedBy = "authorOfBook", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Book> bookListOfAuthor;

    public Author() {
    }

    public Author(String firstNameOfAuthor, String lastNameOfAuthor) {
        this.firstNameOfAuthor = firstNameOfAuthor;
        this.lastNameOfAuthor = lastNameOfAuthor;
    }

    public Long getIdOfAuthor() {
        return idOfAuthor;
    }

    public void setIdOfAuthor(Long idOfAuthor) {
        this.idOfAuthor = idOfAuthor;
    }

    public List<Book> getBookListOfAuthor() {
        return bookListOfAuthor;
    }

    public void setBookListOfAuthor(List<Book> bookListOfAuthor) {
        this.bookListOfAuthor = bookListOfAuthor;
    }

    public String getMiddleNameOfAuthor() {
        return middleNameOfAuthor;
    }

    public void setMiddleNameOfAuthor(String middleNameOfAuthor) {
        this.middleNameOfAuthor = middleNameOfAuthor;
    }

    public String getLastNameOfAuthor() {
        return lastNameOfAuthor;
    }

    public void setLastNameOfAuthor(String lastNameOfAuthor) {
        this.lastNameOfAuthor = lastNameOfAuthor;
    }

    public String getFirstNameOfAuthor() {
        return firstNameOfAuthor;
    }

    public void setFirstNameOfAuthor(String firstNameOfAuthor) {
        this.firstNameOfAuthor = firstNameOfAuthor;
    }
}
