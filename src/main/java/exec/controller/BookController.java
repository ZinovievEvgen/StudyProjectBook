package exec.controller;

import exec.models.Book;
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

    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/get")
    public List<Book> findBookByAuthor(@RequestParam(value = "author") String author) {
        return bookService.findBookByAuthor(author);
    }



    @GetMapping("/allBooks")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping(value = "/create")
    public List<Book> createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteBook(@RequestParam(value = "author") String authorOfBook,
                                     @RequestParam(value = "title") String titleOfBook) {
        bookService.deleteBookByAuthorAndTitle(authorOfBook, titleOfBook);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
