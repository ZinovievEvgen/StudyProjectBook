package exec.service;


import exec.models.Book;

import java.util.List;

public interface BookService {

    List<Book> createBook(Book book);

    List<Book> getBooks();

    Book getBookById(long id);

    List<Book> findBookByAuthor(String author);

    Book findBookByAuthorAndTitle(String author, String Title);

    void deleteBookByAuthorAndTitle(String author, String title);
}
