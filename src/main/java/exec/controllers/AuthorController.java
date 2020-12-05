package exec.controllers;

import exec.models.Author;
import exec.models.Book;
import exec.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/author")
public class AuthorController {

    @Autowired
    private final AuthorService authorService;

    private Logger log = Logger.getLogger(AuthorController.class.getName());

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/create")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @GetMapping("/allAuthors")
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("/get-book-for-author/{id}")
    public List<Book> getBookForAuthor(@PathVariable Long id) {
        return authorService.getBookForAuthors(id);
    }

    @PostMapping("/create-with-book")
    public Author createAuthorWithBooks(@RequestBody Author author) {
        return authorService.createAuthorWithBooks(author);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAuthorById(@PathVariable Long id) {
        try {
            authorService.deleteAuthorById(id);
            log.info("Author (id = " + id + ") was deleted");
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
