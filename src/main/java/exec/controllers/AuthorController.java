package exec.controllers;

import exec.models.Author;
import exec.models.Book;
import exec.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

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
    public Map<Author, List<Book>> createAuthorWithBooks(@RequestBody Author author) {
        Author currentAuthor = authorService.createAuthorWithBooks(author);
        Map<Author, List<Book>> resultMap = new HashMap<>();
        resultMap.put(currentAuthor, currentAuthor.getBookList());
        return resultMap;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAuthorById(@PathVariable Long id) {
        try {
            authorService.deleteAuthorById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
