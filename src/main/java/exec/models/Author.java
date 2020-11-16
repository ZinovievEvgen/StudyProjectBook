package exec.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long idOfAuthor;

    @Column(name = "firstNameOfAuthor")
    private String firstNameOfAuthor;

    @Column(name = "lastNameOfAuthor")
    private String lastNameOfAuthor;

    @Column(name = "middleNameOfAuthor")
    private String middleNameOfAuthor;

    @OneToMany(mappedBy = "authorOfBook", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Book> bookListOfAuthor;

    public Author() {
    }
}
