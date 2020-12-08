package exec.controllers;

import exec.models.Author;
import exec.models.Book;
import exec.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "/api/author", tags = {"Контроллер сущности Author(Автор)"})
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/create")
    @ApiOperation(value = "Создать автора")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @GetMapping("/allAuthors")
    @ApiOperation(value = "Вывести всех авторов")
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("/get-book-for-author/{id}")
    @ApiOperation(value = "Вывести книги по авторам")
    public List<Book> getBookForAuthor(@PathVariable Long id) {
        return authorService.getBookForAuthors(id);
    }

    @PostMapping("/create-with-book")
    @ApiOperation(value = "Добавить автора с книгами")
    public Map<Author, List<Book>> createAuthorWithBooks(@RequestBody Author author) {
        Author currentAuthor = authorService.createAuthorWithBooks(author);
        Map<Author, List<Book>> resultMap = new HashMap<>();
        resultMap.put(currentAuthor, currentAuthor.getBookList());
        return resultMap;
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить автора по его id")
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
