package exec.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dimGenre")
public class DimGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private long idOfDimGenre;

    @Column(name = "genreName")
    private String genreName;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Book.class)
    @JoinTable(name = "bookGenreLnk",
            joinColumns = {@JoinColumn(name = "genre_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    @JsonBackReference
    private List<Book> books;

    public DimGenre() {
    }
}
