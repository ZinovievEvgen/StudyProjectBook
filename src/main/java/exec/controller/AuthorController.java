package exec.controller;

import exec.models.Author;
import exec.models.Book;
import exec.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/author"})
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/allAuthors")
    public List<Author> getAllAuthor() {
        return authorService.getAllAuthor();
    }

    @GetMapping("/getOfBookForAuthor/{id}")
    public List<Book> getListOfBookForAuthor(@PathVariable Long id) {
        return authorService.getListOfBookForAuthor(id);
    }

    @PostMapping(value = "/create")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @PostMapping(value = "/createWithAttributes")
    public Author createAuthorWithAttributes(@RequestBody Author author) {
        return authorService.createAuthorWithBooks(author);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAuthorById(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/get/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PutMapping("/update/{id}")
    public Author updateAuthor(Long id, Author author) {
        return authorService.updateAuthor(id, author);
    }
}
