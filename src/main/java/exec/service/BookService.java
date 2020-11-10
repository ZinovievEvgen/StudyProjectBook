package exec.service;


import exec.models.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {

    List<Book> createBook(Book book);

    List<Book> getBooks();

    Book getBookById(long id);

    List<Book> findBookByAuthor(String author);

    ResponseEntity deleteBookByAuthorAndTitle(String author, String title);
}
