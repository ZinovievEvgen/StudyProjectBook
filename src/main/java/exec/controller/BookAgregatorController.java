package exec.controller;


import exec.models.Book;
import exec.models.BookAgregator;
import exec.service.BookAgregatorService;
import exec.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = {"/api/bookAgregator"})
public class BookAgregatorController {

    @Autowired
    BookAgregatorService bookAgregatorService;

    @Autowired
    PersonService personService;

    @PostMapping(value = "/create")
    public List<BookAgregator> createBookAgregator(@RequestBody BookAgregator bookAgregator,
                                                   @RequestParam(value = "surname") String surnameOfPerson,
                                                   @RequestParam(value = "name") String nameOfPerson) {
        bookAgregator.setPerson(personService.findPersonByNameAndSurname(nameOfPerson, surnameOfPerson));
        return bookAgregatorService.createBookAgregator(bookAgregator, new Date());
    }

    @GetMapping("/allBookAgregators")
    public List<BookAgregator> getBookAgregators() {
        return bookAgregatorService.getBookAgregators();
    }

}
