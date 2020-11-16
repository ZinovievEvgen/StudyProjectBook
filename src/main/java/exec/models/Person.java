package exec.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
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

    @Column(name = "firstNameOfPerson")
    private String firstNameOfPerson;

    @Column(name = "lastNameOfPerson")
    private String lastNameOfPerson;

    @Column(name = "middleNameOfPerson")
    private String middleNameOfPerson;

    @Column(name = "birthDateOfPerson")
    private String birthDateOfPerson;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Book> bookListOfPerson;

    public Person() {
    }
}
