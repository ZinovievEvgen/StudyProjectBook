package exec.service_impl;

import exec.models.Book;
import exec.repository.AuthorRepository;
import exec.repository.BookRepository;
import exec.repository.DimGenreRepository;
import exec.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.System.out;


@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookRepository repository;

    @Autowired
    private DimGenreRepository dimGenreRepository;

    @Autowired
    private AuthorRepository authorRepository;

    // with author and genre
    @Override
    public Book createBookWithAuthorAndGenre(Book book) {
        return null;
    }

    @Override
    public Book createBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book currentBook) {
        return repository.findById(id).map(book -> {
            book.setNameOfBook(currentBook.getNameOfBook());
            book.setGenres(currentBook.getGenres());
            book.setPerson(currentBook.getPerson());
            book.setAuthorOfBook(currentBook.getAuthorOfBook());
            return repository.save(book);
        }).orElseGet(() -> {
            currentBook.setIdOfBook(id);
            return repository.save(currentBook);
        });
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
    public Book addGenreForBook(Long id, Book currentBook) throws Exception {
        return repository.findById(id).map(book -> {
            book.setGenres(currentBook.getGenres());
            return repository.save(book);
        }).orElseThrow(Exception::new);
    }

    @Override
    public void deleteGenreForBook(Long id, Book currentBook) throws Exception {
        repository.findById(id).map(book -> {
            book.setGenres(currentBook.getGenres());
            return repository.save(book);
        }).orElseThrow(Exception::new);
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public List<Book> getAllBooksForAuthor(String firstNameOfAuthor, String lastNameOfAuthor, String middleNameOfAuthor) {
        return repository.findAll().stream().filter(
                book -> book.getAuthorOfBook().getFirstNameOfAuthor().equals(firstNameOfAuthor)
                        || book.getAuthorOfBook().getLastNameOfAuthor().equals(lastNameOfAuthor)
                        || book.getAuthorOfBook().getMiddleNameOfAuthor().equals(middleNameOfAuthor)
        ).collect(Collectors.toList());
    }

    // Книга + жанр + автор
    @Override
    public List<Book> getAllBooksForGenre(Long idOfDimGenre) {
        return dimGenreRepository.getOne(idOfDimGenre).getBooks();
    }

    @Override
    public Book getBookById(Long id) {
        Optional<Book> book = repository.findById(id);
        if (book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
    }
}
