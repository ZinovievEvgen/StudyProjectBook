package exec.service_impl;

import exec.models.Author;
import exec.models.Book;
import exec.repository.AuthorRepository;
import exec.repository.BookRepository;
import exec.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Book> getBookForAuthors(Long id) {
        //output: автор + книги + жанры
        Optional<Author> currentPerson = authorRepository.findById(id);
        if (currentPerson.isPresent()) {
            return currentPerson.get().getBookListOfAuthor();
        } else return Collections.emptyList();
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
    public void deleteAuthorById(Long id) {
        //если только нет книг, иначе кидать ошибку с пояснением, что нельзя удалить автора пока есть его книги)
        try {
            authorRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
