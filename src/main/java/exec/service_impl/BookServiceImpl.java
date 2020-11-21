package exec.service_impl;

import exec.models.Book;
import exec.repository.BookRepository;
import exec.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.System.out;


@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookRepository repository;

    // with author and genre
    @Override
    public Book createBook(Book book) {
        return null;
    }

    // но только если она не у пользователя - ок, или ошибка, что книга у пользователя
    @Override
    public void deleteBookById(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            out.println(e.getMessage());

        }
    }

    /*
    PUT с телом. На вход сущность Book или её Dto) При добавлении или удалении вы должны просто либо добавлять запись,
    либо удалять из списка жанров. Каскадно удалять все жанры и книги с таким жанром нельзя! Книга + жанр + автор
     */
    @Override
    public void addGenreForBook(Book book) {

    }

    @Override
    public void deleteGenreForBook(Book book) {

    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public List<Book> getAllBooksForAuthor(String firstNameOfAuthor, String lastNameOfAuthor, String middleNameOfAuthor) {
        return null;
    }

    // Книга + жанр + автор
    @Override
    public List<Book> getAllBooksForGenre(Long idOfDimGenre) {
        return null;
    }

    @Override
    public Book getBookById(long id) {
        Optional<Book> book = repository.findById(id);
        if (book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
    }
}
