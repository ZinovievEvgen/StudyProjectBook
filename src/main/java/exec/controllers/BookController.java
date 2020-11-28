package exec.controllers;

import exec.models.Author;
import exec.models.Book;
import exec.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PostMapping("/create-with-atr")
    public Book createBookWithAuthorAndGenre(@RequestBody Book book,
                                             @RequestParam(value = "idOfAuthor") Long idOfAuthor,
                                             @RequestParam(value = "idOfGenre") Long idOfGenre) throws Exception {
        return bookService.createBookWithAuthorAndGenre(book, idOfAuthor, idOfGenre);
    }

    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book newBook) {
        return bookService.updateBook(id, newBook);
    }

    @GetMapping("/allBooks")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBookById(@PathVariable Long id) {
        try {
            bookService.deleteBookById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/get-book-for-genre")
    public List<Book> bookForGenre(@RequestParam(value = "nameOfGenre") String nameOfGenre) {
        return bookService.bookForGenre(nameOfGenre);
    }

    @GetMapping("/get-book-for-author")
    public List<Book> getAllBooksForAuthor(@RequestParam(value = "first") String firstNameOfAuthor,
                                           @RequestParam(value = "last") String lastNameOfAuthor,
                                           @RequestParam(value = "middle") String middleNameOfAuthor) {
        return bookService.getAllBooksForAuthor(firstNameOfAuthor, lastNameOfAuthor, middleNameOfAuthor);
    }

    @PutMapping("/update-genre/{id}")
    public Book updateGenreForBook(@PathVariable Long id, @RequestBody Book currentBook) {
        return bookService.updateGenreForBook(id, currentBook);
    }
}
