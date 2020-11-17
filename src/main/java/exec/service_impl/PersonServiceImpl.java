package exec.service_impl;


import exec.models.Person;
import exec.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        return personList.stream().filter(person -> nameOfPerson.equals(person.getNameOfPerson()) && surnameOfPerson.equals(person.getSurnameOfPerson()))
                .findAny()
                .orElse(null);
    }

    @Override
    public void deletePersonByFullName(String nameOfPerson, String surnameOfPerson, String middleNameOfPerson) {
        Person newDelPerson = new Person();
        newDelPerson = personList.stream().filter(person -> nameOfPerson.equals(person.getNameOfPerson())
                && surnameOfPerson.equals(person.getSurnameOfPerson()) && middleNameOfPerson.equals(person.getMiddleNameOfPerson()))
                .findAny()
                .orElse(null);
        personList.remove(newDelPerson);
        logger.info("Удаление прошло успешнно. Удалена запись с id = " + newDelPerson.getIdOfPerson());
    }
}
