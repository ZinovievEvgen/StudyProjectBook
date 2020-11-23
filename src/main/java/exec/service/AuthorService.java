package exec.service;

import exec.models.Author;
import exec.models.Book;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthor();

    List<Book> getListOfBookForAuthor(Long id);

    Author createAuthor(Author author);

    Author createAuthorWithBooks(Author author);

    Author updateAuthor(Long id, Author author);

    void deleteAuthorById(Long id);

    Author getAuthorById(Long id);
}
