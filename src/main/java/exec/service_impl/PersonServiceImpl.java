package exec.service_impl;


import exec.models.Person;
import exec.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersonServiceImpl implements PersonService {

    private List<Person> personList = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Override
    public List<Person> createPerson(Person person) {
        personList.add(person);
        logger.info(String.format("Add person%s", person));
        return personList;
    }

    @Override
    public List<Person> getPersons() {
        return personList;
    }

    @Override
    public Person getPersonById(long id) {
        Person resultPerson;
        resultPerson = personList.get((int) id);
        return resultPerson;
    }

    @Override
    public List<Person> findPersonByName(String name) {
        return personList.stream()
                .filter(person -> name.equals(person.getNameOfPerson()))
                .collect(Collectors.toList());
    }

    @Override
    public Person findPersonByNameAndSurname(String nameOfPerson, String surnameOfPerson) {

        Person newPerson = new Person();
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getNameOfPerson().equals(nameOfPerson)
                    && personList.get(i).getSurnameOfPerson().equals(surnameOfPerson)) {
                newPerson = personList.get(i);
            }
        }
        return newPerson;
    }

    @Override
    public ResponseEntity deletePersonByFIO(String nameOfPerson, String surnameOfPerson, String middleNameOfPerson) {
        Person newDelPerson = new Person();
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getNameOfPerson().equals(nameOfPerson)
                    && personList.get(i).getSurnameOfPerson().equals(surnameOfPerson)
                    && personList.get(i).getMiddleNameOfPerson().equals(middleNameOfPerson)) {
                newDelPerson = personList.get(i);
            }
        }
        personList.remove(newDelPerson);
        return ResponseEntity.ok().build();
    }
}
