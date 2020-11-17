package exec.service;


import exec.models.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);

    void deleteBookById(Long id);

    void addGenreForBook(Book book);

    void deleteGenreForBook(Book book);

    List<Book> getAllBooks();

    List<Book> getAllBooksForAuthor(String firstNameOfAuthor, String lastNameOfAuthor, String middleNameOfAuthor);

    List<Book> getAllBooksForGenre(Long idOfDimGenre);

    Book getBookById(long id);
}
