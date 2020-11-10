package exec.controller;

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

    @GetMapping("/get/{id}")
    public Person getPersonById(@PathVariable long id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/get")
    public List<Person> findPersonByName(@RequestParam(value = "name") String name) {
        return personService.findPersonByName(name);
    }

    @GetMapping("/allPersons")
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @PostMapping(value = "/create")
    public List<Person> createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @DeleteMapping("/delete")
    public void deletePerson(@RequestParam(value = "name") String nameOfPerson,
                             @RequestParam(value = "surname") String surnameOfPerson,
                             @RequestParam(value = "middle") String middleNameOfPerson) {
        personService.deletePersonByFIO(nameOfPerson, surnameOfPerson, middleNameOfPerson);
    }
}
