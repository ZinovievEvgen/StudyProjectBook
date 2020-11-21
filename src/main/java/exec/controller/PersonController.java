package exec.controller;

import exec.models.Book;
import exec.models.Person;
import exec.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/person"})
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/create")
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    public Person updatePerson(Person person) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePersonById(@PathVariable Long id) {
        personService.deletePersonById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/deleteFull")
    public ResponseEntity deletePersonByFullName(@RequestParam(value = "name") String nameOfPerson,
                                                 @RequestParam(value = "surname") String lastOfPerson,
                                                 @RequestParam(value = "middle") String middleNameOfPerson) {
        personService.deletePersonByFullName(nameOfPerson, lastOfPerson, middleNameOfPerson);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/allPersons")
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/get/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
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
