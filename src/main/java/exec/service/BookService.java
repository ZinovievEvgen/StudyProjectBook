package exec.service;


import exec.models.Author;
import exec.models.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);

    Book createBookWithAuthorAndGenre(Book book, Long idOfAuthor, Long idOfGenre) throws Exception;

    Book updateBook(Long id, Book newBook);

    List<Book> getBooks();

    void deleteBookById(Long id);

    List<Book> bookForGenre(String nameOfGenre);

    List<Book> getAllBooksForAuthor(String firstNameOfAuthor, String lastNameOfAuthor, String middleNameOfAuthor);

    Book updateGenreForBook(Long id, Book currentBook);
}
