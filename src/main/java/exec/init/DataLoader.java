package exec.init;


import exec.models.Book;
import exec.models.BookAgregator;
import exec.models.Person;
import exec.service.BookAgregatorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import exec.service.BookService;
import exec.service.PersonService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {


    private final PersonService personService;
    private final BookService bookService;
    private final BookAgregatorService bookAgregatorService;


    public DataLoader(PersonService personService, BookService bookService, BookAgregatorService bookAgregatorService) {
        this.personService = personService;
        this.bookService = bookService;
        this.bookAgregatorService = bookAgregatorService;
    }

    @Override
    public void run(String... strings) throws Exception {
        initData();
    }

    private void initData() {

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");

        System.out.println("exec.init data");

        personService.createPerson(new Person(1L, formatForDateNow.format(dateNow), "Tiger", "Master", "Great5"));
        personService.createPerson(new Person(2L, formatForDateNow.format(dateNow), "Po", "DrakonWarrior", "MasterCI"));
        personService.createPerson(new Person(3L, formatForDateNow.format(dateNow), "Shifu", "Master", "KungFu"));

        bookService.createBook(new Book(1L, "Tales1", "Master", "KungFu"));
        bookService.createBook(new Book(1L, "Tales2", "Master", "KungFu"));
        bookService.createBook(new Book(1L, "Tales3", "Master", "KungFu"));
    }
}
