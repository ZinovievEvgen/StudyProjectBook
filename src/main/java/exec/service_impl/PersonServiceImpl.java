package exec.service_impl;

import exec.models.Book;
import exec.models.Person;
import exec.repository.BookRepository;
import exec.repository.PersonRepository;
import exec.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long id, Person newPerson) {
        return personRepository.findById(id).map(person -> {
            person.setFirstName(newPerson.getFirstName());
            person.setLastName(newPerson.getLastName());
            person.setMiddleName(newPerson.getMiddleName());
            person.setBirthDate(newPerson.getBirthDate());
            return personRepository.save(person);
        }).orElseGet(() -> {
            newPerson.setId(id);
            return personRepository.save(newPerson);
        });
    }

    @Override
    public void deletePersonById(Long id) {
        try {
            personRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deletePersonByFullName(String name, String surname, String middleName) {
        try {
            Person delPerson = personRepository.findByFirstNameAndLastNameAndMiddleName(name,
                    surname, middleName).orElseThrow(Exception::new);
            personRepository.delete(delPerson);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long id) throws Exception {
        return personRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public List<Book> getBookForPerson(Long id) {
        //output: Книги - автор - жанр
        return null;
    }

    @Override
    public Person addBookOnListBookForPerson(Long idPerson, String nameOfBook) throws Exception {
        //output: Пользователь + книги
        return null;
    }

    @Override
    public Person deleteBookOnListBookForPerson(Long idPerson, String nameOfBook) throws Exception {
        // output: Пользователь + книги
        return null;
    }
}
