package exec.controllers;

import exec.models.Book;
import exec.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/book")
@Api(value = "/api/book", tags = {"Контроллер сущности Book(Книги)"})
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    @ApiOperation(value = "Создать книгу")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PostMapping("/create-with-atr")
    @ApiOperation(value = "Создать книгу c жанром и автором")
    public Book createBookWithAuthorAndGenre(@RequestBody Book book,
                                             @RequestParam(value = "idOfAuthor") Long idOfAuthor,
                                             @RequestParam(value = "idOfGenre") Long idOfGenre) throws Exception {
        return bookService.createBookWithAuthorAndGenre(book, idOfAuthor, idOfGenre);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Изменить книгу по ее id")
    public Book updateBook(@PathVariable Long id, @RequestBody Book newBook) {
        return bookService.updateBook(id, newBook);
    }

    @GetMapping("/allBooks")
    @ApiOperation(value = "Вывести все книги")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить книгу по ее id")
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
    @ApiOperation(value = "Вывести книгу по ее жанру")
    public List<Book> bookForGenre(@RequestParam(value = "nameOfGenre") String nameOfGenre) {
        return bookService.bookForGenre(nameOfGenre);
    }

    @GetMapping("/get-book-for-author")
    @ApiOperation(value = "Вывести книгу по ее автору")
    public List<Book> getAllBooksForAuthor(@RequestParam(value = "first") String firstNameOfAuthor,
                                           @RequestParam(value = "last") String lastNameOfAuthor,
                                           @RequestParam(value = "middle") String middleNameOfAuthor) {
        return bookService.getAllBooksForAuthor(firstNameOfAuthor, lastNameOfAuthor, middleNameOfAuthor);
    }

    @PutMapping("/update-genre/{id}")
    @ApiOperation(value = "Изменить жанр у книги")
    public Book updateGenreForBook(@PathVariable Long id, @RequestBody Book currentBook) {
        return bookService.updateGenreForBook(id, currentBook);
    }
}
