package exec.service_impl;

import exec.models.Book;
import exec.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    // with author and genre
    @Override
    public Book createBook(Book book) {
        return null;
    }

    // но только если она не у пользователя - ок, или ошибка, что книга у пользователя
    @Override
    public void deleteBookById(Long id) {

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
        return null;
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
        return null;
    }
}
