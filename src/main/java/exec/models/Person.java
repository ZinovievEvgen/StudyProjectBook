package exec.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-Person: содержит информацию о читателях
 */
@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long idOfPerson;

    @NotNull
    @Column(name = "firstNameOfPerson")
    private String firstNameOfPerson;

    @NotNull
    @Column(name = "lastNameOfPerson")
    private String lastNameOfPerson;

    @Column(name = "middleNameOfPerson")
    private String middleNameOfPerson;

    @Column(name = "birthDateOfPerson")
    private LocalDate birthDateOfPerson;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Book> bookListOfPerson;

    public Person() {
    }

    public Person(@NotNull String firstNameOfPerson, @NotNull String lastNameOfPerson) {
        this.firstNameOfPerson = firstNameOfPerson;
        this.lastNameOfPerson = lastNameOfPerson;
    }

    public Long getIdOfPerson() {
        return idOfPerson;
    }

    public void setIdOfPerson(Long idOfPerson) {
        this.idOfPerson = idOfPerson;
    }

    public List<Book> getBookListOfPerson() {
        return bookListOfPerson;
    }

    public void setBookListOfPerson(List<Book> bookListOfPerson) {
        this.bookListOfPerson = bookListOfPerson;
    }

    public LocalDate getBirthDateOfPerson() {
        return birthDateOfPerson;
    }

    public void setBirthDateOfPerson(LocalDate birthDateOfPerson) {
        this.birthDateOfPerson = birthDateOfPerson;
    }

    public String getMiddleNameOfPerson() {
        return middleNameOfPerson;
    }

    public void setMiddleNameOfPerson(String middleNameOfPerson) {
        this.middleNameOfPerson = middleNameOfPerson;
    }

    public String getLastNameOfPerson() {
        return lastNameOfPerson;
    }

    public void setLastNameOfPerson(String lastNameOfPerson) {
        this.lastNameOfPerson = lastNameOfPerson;
    }

    public String getFirstNameOfPerson() {
        return firstNameOfPerson;
    }

    public void setFirstNameOfPerson(String firstNameOfPerson) {
        this.firstNameOfPerson = firstNameOfPerson;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstNameOfPerson='" + firstNameOfPerson + '\'' +
                ", lastNameOfPerson='" + lastNameOfPerson + '\'' +
                '}';
    }
}
