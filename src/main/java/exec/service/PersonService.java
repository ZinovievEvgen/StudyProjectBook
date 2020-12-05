package exec.service;


import exec.models.Book;
import exec.models.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person updatePerson(Person newPerson);

    void deletePersonById(Long id);

    void deletePersonByFullName(String nameOfPerson, String surnameOfPerson, String middleNameOfPerson);

    List<Person> getPersons();

    Person getPersonById(Long id) throws Exception;

    List<Book> getBookForPerson(Long id);

    Person addBookOnListBookForPerson(Long idPerson, String nameOfBook) throws Exception;

    Person deleteBookOnListBookForPerson(Long idPerson, String nameOfBook) throws Exception;
}
