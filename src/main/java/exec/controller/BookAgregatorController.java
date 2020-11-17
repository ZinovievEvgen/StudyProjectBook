package exec.controller;


import exec.models.Book;
import exec.models.BookAgregator;
import exec.models.Person;
import exec.service.BookAgregatorService;
import exec.service.BookService;
import exec.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = {"/api/bookAgregator"})
public class BookAgregatorController {

    @Autowired
    private BookAgregatorService bookAgregatorService;

    @Autowired
    private PersonService personService;

    @Autowired
    private BookService bookService;

    private ZonedDateTime now = ZonedDateTime.now();

    @PostMapping(value = "/create")
    public List<BookAgregator> createBookAgregator(@RequestParam(value = "surname") String surnameOfPerson,
                                                   @RequestParam(value = "name") String nameOfPerson,
                                                   @RequestParam(value = "author") String authorOfBook,
                                                   @RequestParam(value = "title") String titleOfBook) {

        BookAgregator bookAgregator = new BookAgregator();

        bookAgregator.setBook(bookService.findBookByAuthorAndTitle(authorOfBook, titleOfBook));

        bookAgregator.setPerson(personService.findPersonByNameAndSurname(nameOfPerson, surnameOfPerson));

        bookAgregator.setDateToGiveBook(now);

        return bookAgregatorService.createBookAgregator(bookAgregator);
    }

    @GetMapping("/allBookAgregators")
    public List<BookAgregator> getBookAgregators() {
        return bookAgregatorService.getBookAgregators();
    }

}
