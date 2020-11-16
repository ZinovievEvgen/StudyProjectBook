package exec.service;

import exec.models.Author;

import java.util.List;

public interface AuthorService {

    Author getAuthorById(Long id);

    void addAuthor(Author author);

    List<Author> getAllAuthor();

    void deleteAuthorById(Long id);

    void updateAuthor(Author author);
}
