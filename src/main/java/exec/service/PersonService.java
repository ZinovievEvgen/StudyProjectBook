package exec.service;


import exec.models.Book;
import exec.models.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person updatePerson(Person person);

    void deletePersonById(Long id);

    void deletePersonByFullName(String nameOfPerson, String surnameOfPerson, String middleNameOfPerson);

    List<Person> getPersons();

    Person getPersonById(Long id);

    List<Book> getBookForPerson(Long id);

    Person addBookOnListBookForPerson(Book book);

    Person deleteBookOnListBookForPerson(Book book);
}
