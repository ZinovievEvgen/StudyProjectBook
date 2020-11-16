package exec.service_impl;


import exec.models.Person;
import exec.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public List<Person> createPerson(Person person) {
        return null;
    }

    @Override
    public List<Person> getPersons() {
        return null;
    }

    @Override
    public Person getPersonById(long id) {
        return null;
    }

    @Override
    public List<Person> findPersonByName(String name) {
        return null;
    }

    @Override
    public Person findPersonByNameAndSurname(String nameOfPerson, String surnameOfPerson) {
        return null;
    }

    @Override
    public void deletePersonByFullName(String nameOfPerson, String surnameOfPerson, String middleNameOfPerson) {

    }
}
