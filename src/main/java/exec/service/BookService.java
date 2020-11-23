package exec.service;


import exec.models.Book;
import exec.models.DimGenre;

import java.util.List;

public interface BookService {

    Book createBook(Book book);

    Book updateBook(Long id, Book book);

    Book createBookWithAuthorAndGenre(Book book);

    void deleteBookById(Long id);

    Book addGenreForBook(Long id, Book book) throws Exception;

    void deleteGenreForBook(Long id, Book currentBook) throws Exception;

    List<Book> getAllBooks();

    List<Book> getAllBooksForAuthor(String firstNameOfAuthor, String lastNameOfAuthor, String middleNameOfAuthor);

    List<Book> getAllBooksForGenre(Long idOfDimGenre);

    Book getBookById(Long id);
}
