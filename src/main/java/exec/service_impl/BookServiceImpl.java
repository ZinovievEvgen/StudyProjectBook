package exec.service_impl;

import exec.models.Book;
import exec.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {


    @Override
    public List<Book> createBook(Book book) {
        return null;
    }

    @Override
    public List<Book> getBooks() {
        return null;
    }

    @Override
    public Book getBookById(long id) {
        return null;
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        return null;
    }

    @Override
    public Book findBookByAuthorAndTitle(String author, String Title) {
        return null;
    }

    @Override
    public void deleteBookByAuthorAndTitle(String author, String title) {

    }
}
