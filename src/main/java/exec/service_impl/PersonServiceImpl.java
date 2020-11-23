package exec.service_impl;


import exec.models.Book;
import exec.models.Person;
import exec.repository.PersonRepository;
import exec.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.System.out;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;


    @Override
    public Person createPerson(Person person) {
        return repository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return repository.save(person);
    }

    @Override
    public void deletePersonById(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            out.println(e.getMessage());

        }
    }

    @Override
    public void deletePersonByFullName(String nameOfPerson, String lastNameOfPerson, String middleNameOfPerson) {
        try {
            Person delPerson = repository.findByFirstNameOfPersonAndLastNameOfPersonAndMiddleNameOfPerson(nameOfPerson,
                    lastNameOfPerson, middleNameOfPerson).orElseThrow(Exception::new);
            repository.delete(delPerson);
        } catch (Exception e) {
            out.println(e.getMessage());

        }
    }

    @Override
    public List<Person> getPersons() {
        return repository.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        Optional<Person> person = repository.findById(id);
        if (person.isPresent()) {
            return person.get();
        } else {
            return null;
        }
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
