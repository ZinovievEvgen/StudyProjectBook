package exec.service;


import exec.models.Person;

import java.util.List;

public interface PersonService {

    List<Person> createPerson(Person person);

    List<Person> getPersons();

    Person getPersonById(long id);

    List <Person> findPersonByName(String name);

    Person findPersonByNameAndSurname(String nameOfPerson, String surnameOfPerson);

    void deletePersonByFullName(String nameOfPerson, String surnameOfPerson, String middleNameOfPerson);
}
