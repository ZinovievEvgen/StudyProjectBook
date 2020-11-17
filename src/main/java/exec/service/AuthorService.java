package exec.service;

import exec.models.Author;
import exec.models.Book;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthor();

    List<Book> getListOfBookForAuthor(Author author);

    Author createAuthor(Author author);

    void deleteAuthorById(Long id);

    Author getAuthorById(Long id);
}
