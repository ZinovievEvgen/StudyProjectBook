package exec.service_impl;

import exec.exception.NotFoundEntityException;
import exec.models.Author;
import exec.models.Book;
import exec.repository.AuthorRepository;
import exec.repository.BookRepository;
import exec.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    private Logger log = Logger.getLogger(AuthorServiceImpl.class.getName());

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Book> getBookForAuthors(Long id) throws Exception {
        Author currentPerson = authorRepository.findById(id).orElseThrow(Exception::new);
        return currentPerson.getBookListOfAuthor();
    }

    @Override
    public Author createAuthorWithBooks(Author author) {
        //автор + книги
        Author saveAuthor = authorRepository.save(author);
        author.getBookListOfAuthor().stream().forEach(book -> {
            book.setAuthorOfBook(saveAuthor);
            bookRepository.save(book);
        });
        return saveAuthor;
    }

    @Override
    public void deleteAuthorById(Long id) throws NotFoundEntityException {
        //если только нет книг, иначе кидать ошибку с пояснением, что нельзя удалить автора пока есть его книги)
        try {
            authorRepository.deleteById(id);
            log.info("Author (id = " + id + ") was deleted");
        } catch (Exception e) {
            log.warning("Could not find client with ID " + id);
            throw new NotFoundEntityException(
                    "Could not find client with ID " + id);
        }
    }
}
