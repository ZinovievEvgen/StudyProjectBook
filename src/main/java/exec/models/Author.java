package exec.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-Author: содержит информацию об авторах книг
 */
@Entity
@Table(name = "author")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long idOfAuthor;

    @NotNull
    @Column(name = "firstNameOfAuthor")
    private String firstNameOfAuthor;

    @NotNull
    @Column(name = "lastNameOfAuthor")
    private String lastNameOfAuthor;

    @Column(name = "middleNameOfAuthor")
    private String middleNameOfAuthor;

    @OneToMany(mappedBy = "authorOfBook", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "author-book")
    private List<Book> bookListOfAuthor;

    public Author() {
    }

    public Author(@NotNull String firstNameOfAuthor, @NotNull String lastNameOfAuthor, String middleNameOfAuthor) {
        this.firstNameOfAuthor = firstNameOfAuthor;
        this.lastNameOfAuthor = lastNameOfAuthor;
        this.middleNameOfAuthor = middleNameOfAuthor;
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

    @Override
    public String toString() {
        return "Author{" +
                "firstNameOfAuthor='" + firstNameOfAuthor + '\'' +
                ", lastNameOfAuthor='" + lastNameOfAuthor + '\'' +
                '}';
    }
}
