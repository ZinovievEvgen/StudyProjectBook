package exec.controller;

import exec.models.Book;
import exec.models.DimGenre;
import exec.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/book"})
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/create")
    public Book createBook(Book book) {
        return bookService.createBook(book);
    }

    @PostMapping(value = "/createWithAttributes")
    public Book createBookWithAuthorAndGenre(Book book) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(value = "/addGenreForBook/{id}")
    public Book addGenreForBook(@PathVariable Long id, Book book) {
        return bookService.addGenreForBook(id, book);
    }

    @DeleteMapping("/deleteGenreForBook/{id}")
    public ResponseEntity deleteGenreForBook(Book book) {
        bookService.deleteGenreForBook(book);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/allBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getAllBooksForAuthor")
    public List<Book> getAllBooksForAuthor(@RequestParam(value = "firstName") String firstNameOfAuthor,
                                           @RequestParam(value = "lastName") String lastNameOfAuthor,
                                           @RequestParam(value = "middleName") String middleNameOfAuthor) {
        return bookService.getAllBooksForAuthor(firstNameOfAuthor, lastNameOfAuthor, middleNameOfAuthor);
    }

    @GetMapping("/getAllBooksForGenre/{id}")
    public List<Book> getAllBooksForGenre(@PathVariable Long idOfDimGenre) {
        return bookService.getAllBooksForGenre(idOfDimGenre);
    }

    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
}
