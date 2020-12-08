package exec.controllers;

import exec.models.Book;
import exec.models.Person;
import exec.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/person")
@Api(value = "/api/person", tags = {"Контроллер сущности Person(Пользователь)"})
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/create")
    @ApiOperation(value = "Создать person")
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Изменить person")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person newPerson) {
        return personService.updatePerson(id, newPerson);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить person по id")
    public ResponseEntity deletePersonById(@PathVariable Long id) {
        try {
            personService.deletePersonById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/delete-with-atr")
    @ApiOperation(value = "Удалить person по его ФИО")
    public ResponseEntity deletePersonByFullName(@RequestParam(value = "name") String nameOfPerson,
                                                 @RequestParam(value = "last") String lastOfPerson,
                                                 @RequestParam(value = "middle") String middleNameOfPerson) {
        try {
            personService.deletePersonByFullName(nameOfPerson, lastOfPerson, middleNameOfPerson);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/allPersons")
    @ApiOperation(value = "Вывести всех имеющихся объектов person")
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Вывести person по его id")
    public Person getPersonById(@PathVariable Long id) throws Exception {
        return personService.getPersonById(id);
    }

    @GetMapping("/get-book-for-person/{id}")
    @ApiOperation(value = "Вывести список книг у person по его id")
    public List<Book> getBookForPerson(@PathVariable Long id) {
        return personService.getBookForPerson(id);
    }

    /*@PutMapping("/add-book-for-person/{id}")
    @ApiOperation(value = "Добавить книгу в список выбранному person")
    public Map<Person, List<Book>> addBookOnListBookForPerson(@PathVariable Long id, @RequestParam(value = "name") String nameOfBook) throws Exception {
        Person currentPerson = personService.addBookOnListBookForPerson(id, nameOfBook);
        Map<Person, List<Book>> resultMap = new HashMap<>();
        resultMap.put(currentPerson, currentPerson.getBookList());
        return resultMap;
    }*/

    /*@PutMapping("/delete-book-for-person/{id}")
    @ApiOperation(value = "Удалить книгу из списка конкретного person")
    public Map<Person, List<Book>> deleteBookOnListBookForPerson(@PathVariable Long id, @RequestParam(value = "name") String nameOfBook) throws Exception {
        Person currentPerson = personService.deleteBookOnListBookForPerson(id, nameOfBook);
        Map<Person, List<Book>> resultMap = new HashMap<>();
        resultMap.put(currentPerson, currentPerson.getBookList());
        return resultMap;
    }*/
}
