package exec.service_impl;

import exec.models.Book;
import exec.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService {


    private List<Book> bookList = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Override
    public List<Book> createBook(Book book) {
        bookList.add(book);
        logger.info(String.format("Add book%s", book));
        return bookList;
    }

    @Override
    public List<Book> getBooks() {
        return bookList;
    }

    @Override
    public Book getBookById(long id) {
        Book resultBook;
        resultBook = bookList.get((int) id);
        return resultBook;
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        return bookList.stream()
                .filter(book -> author.equals(book.getAuthorOfBook()))
                .collect(Collectors.toList());
    }

    @Override
    public Book findBookByAuthorAndTitle(String author, String title) {
        return bookList.stream().filter(book -> author.equals(book.getAuthorOfBook()) && title.equals(book.getTitleOfBook()))
                .findAny()
                .orElse(null);
    }

    @Override
    public void deleteBookByAuthorAndTitle(String author, String title) {
        Book newDelBook = new Book();
        newDelBook = bookList.stream().filter(book -> author.equals(book.getAuthorOfBook()) && title.equals(book.getTitleOfBook()))
                .findAny()
                .orElse(null);
        bookList.remove(newDelBook);
        logger.info("Удаление прошло успешнно. Удалена запись с id = " + newDelBook.getIdOfBook());
    }
}
