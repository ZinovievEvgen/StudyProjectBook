package exec.service;


import exec.exception.NotFoundEntityException;
import exec.models.Author;
import exec.models.Book;

import java.util.List;

public interface AuthorService {

    Author createAuthor(Author author);

    List<Author> getAuthors();

    List<Book> getBookForAuthors(Long id) throws Exception;

    Author createAuthorWithBooks(Author author);

    void deleteAuthorById(Long id) throws NotFoundEntityException;
}
