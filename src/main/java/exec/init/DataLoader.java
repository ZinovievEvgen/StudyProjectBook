package exec.init;


import exec.models.Person;
import exec.service.AuthorService;
import exec.service.BookService;
import exec.service.DimGenreService;
import exec.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.lang.System.out;

@Component
public class DataLoader implements CommandLineRunner {


    private final PersonService personService;
    private final BookService bookService;
    private final AuthorService authorService;
    private final DimGenreService dimGenreService;


    public DataLoader(PersonService personService, BookService bookService,
                      AuthorService authorService, DimGenreService dimGenreService) {
        this.personService = personService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.dimGenreService = dimGenreService;
    }

    @Override
    public void run(String... strings) throws Exception {
        initData();
    }

    private void initData() {
        out.println("exec.init data");
        personService.createPerson(new Person("Иван", "Иванов", "Иванович", LocalDate.now()));
        personService.createPerson(new Person("Семен", "Семенов", "Семенович", LocalDate.now()));
        personService.createPerson(new Person("Петр", "Петров", "Петрович", LocalDate.now()));
    }
}
