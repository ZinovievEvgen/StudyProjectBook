package exec.service_impl;


import exec.models.Book;
import exec.models.Person;
import exec.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public Person createPerson(Person person) {
        return null;
    }

    @Override
    public Person updatePerson(Person person) {
        return null;
    }

    // ok - exeption (if id empty)
    @Override
    public void deletePersonById(Long id) {

    }

    // ok - exeption (if id empty)
    @Override
    public void deletePersonByFullName(String nameOfPerson, String surnameOfPerson, String middleNameOfPerson) {

    }

    @Override
    public List<Person> getPersons() {
        return null;
    }

    @Override
    public Person getPersonById(long id) {
        return null;
    }

    //input book-author-genre
    @Override
    public List<Book> getBookForPerson(Long id) {
        return null;
    }

    // input person + books
    @Override
    public Person addBookOnListBookForPerson(Book book) {
        return null;
    }

    // input person + books
    @Override
    public Person deleteBookOnListBookForPerson(Book book) {
        return null;
    }
}
