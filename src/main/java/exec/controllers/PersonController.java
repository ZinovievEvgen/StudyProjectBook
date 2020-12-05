package exec.controllers;

import exec.models.Book;
import exec.models.Person;
import exec.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    private Logger log = Logger.getLogger(PersonController.class.getName());

    @PostMapping("/create")
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("/update")
    public Person updatePerson(@RequestBody Person newPerson) {
        return personService.updatePerson(newPerson);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePersonById(@PathVariable Long id) {
        try {
            personService.deletePersonById(id);
            log.info("Person (id = " + id + ") was deleted");
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/delete-with-atr")
    public ResponseEntity deletePersonByFullName(@RequestParam(value = "name") String nameOfPerson,
                                                 @RequestParam(value = "last") String lastOfPerson,
                                                 @RequestParam(value = "middle") String middleNameOfPerson) {
        try {
            personService.deletePersonByFullName(nameOfPerson, lastOfPerson, middleNameOfPerson);
            log.info("Person was deleted");
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/allPersons")
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/get/{id}")
    public Person getPersonById(@PathVariable Long id) throws Exception {
        return personService.getPersonById(id);
    }

    @GetMapping("/get-book-for-person/{id}")
    public List<Book> getBookForPerson(@PathVariable Long id) {
        return personService.getBookForPerson(id);
    }

    @PutMapping("/add-book-for-person/{id}")
    public Map<Person, List<Book>> addBookOnListBookForPerson(@PathVariable Long id, @RequestParam(value = "name") String nameOfBook) throws Exception {
        Person currentPerson = personService.addBookOnListBookForPerson(id, nameOfBook);
        Map<Person, List<Book>> resultMap = new HashMap<>();
        resultMap.put(currentPerson, currentPerson.getBookListOfPerson());
        return resultMap;
    }

    @PutMapping("/delete-book-for-person/{id}")
    public Map<Person, List<Book>> deleteBookOnListBookForPerson(@PathVariable Long id, @RequestParam(value = "name") String nameOfBook) throws Exception {
        Person currentPerson = personService.deleteBookOnListBookForPerson(id, nameOfBook);
        Map<Person, List<Book>> resultMap = new HashMap<>();
        resultMap.put(currentPerson, currentPerson.getBookListOfPerson());
        return resultMap;
    }
}
