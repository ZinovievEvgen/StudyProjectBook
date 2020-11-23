package exec.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-Person: содержит информацию о читателях
 */
@Entity
@Table(name = "person")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long idOfPerson;

    @Column(name = "firstNameOfPerson", nullable = false)
    private String firstNameOfPerson;

    @Column(name = "lastNameOfPerson", nullable = false)
    private String lastNameOfPerson;

    @Column(name = "middleNameOfPerson")
    private String middleNameOfPerson;

    @Column(name = "birthDateOfPerson")
    private LocalDate birthDateOfPerson;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Book> bookListOfPerson;

    public Person() {
    }

    public Person(String firstNameOfPerson, String lastNameOfPerson) {
        this.firstNameOfPerson = firstNameOfPerson;
        this.lastNameOfPerson = lastNameOfPerson;
    }

    public Person(String firstNameOfPerson, String lastNameOfPerson, String middleNameOfPerson, LocalDate birthDateOfPerson) {
        this.firstNameOfPerson = firstNameOfPerson;
        this.lastNameOfPerson = lastNameOfPerson;
        this.middleNameOfPerson = middleNameOfPerson;
        this.birthDateOfPerson = birthDateOfPerson;
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
}
