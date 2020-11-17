package exec.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-Person: содержит информацию о читателях
 */
@Entity
@Table(name = "person")
public class Person {

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private ZonedDateTime birthDateOfPerson;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Book> bookListOfPerson;

    public Person() {
    }

    public Person(String firstNameOfPerson, String lastNameOfPerson) {
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

    public ZonedDateTime getBirthDateOfPerson() {
        return birthDateOfPerson;
    }

    public void setBirthDateOfPerson(ZonedDateTime birthDateOfPerson) {
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
