package exec.controller;

import exec.models.Book;
import exec.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import exec.service.PersonService;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/person"})
public class PersonController {

    @Autowired
    private PersonService personService;

    public Person createPerson(Person person) {
        return null;
    }

    public Person updatePerson(Person person) {
        return null;
    }

    public ResponseEntity deletePersonById(Long id) {
        // ok - exeption (if id empty)
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity deletePersonByFullName(String nameOfPerson, String surnameOfPerson, String middleNameOfPerson) {
        {
            // ok - exeption (if id empty)
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }

    public List<Person> getPersons() {
        return null;
    }

    public Person getPersonById(long id) {
        return null;
    }

    public List<Book> getBookForPerson(Long id) {
        //input book-author-genre
        return null;
    }

    public Person addBookOnListBookForPerson(Book book) {
        // input person + books
        return null;
    }

    public Person deleteBookOnListBookForPerson(Book book) {
        // input person + books
        return null;
    }
}
