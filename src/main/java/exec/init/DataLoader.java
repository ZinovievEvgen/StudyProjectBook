package exec.init;


import exec.service.BookService;
import exec.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {


    private final PersonService personService;
    private final BookService bookService;


    public DataLoader(PersonService personService, BookService bookService) {
        this.personService = personService;
        this.bookService = bookService;
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
