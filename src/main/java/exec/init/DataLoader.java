package exec.init;


import exec.service.AuthorService;
import exec.service.BookService;
import exec.service.DimGenreService;
import exec.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

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

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");

        System.out.println("exec.init data");


    }
}
