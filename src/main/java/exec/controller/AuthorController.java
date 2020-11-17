package exec.controller;

import exec.models.Author;
import exec.models.Book;
import exec.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/author"})
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    public List<Author> getAllAuthor() {
        return null;
    }

    public List<Book> getListOfBookForAuthor(Author author) {
        return null;
    }

    public Author createAuthor(Author author) {
        return null;
    }

    public void deleteAuthorById(Long id) {

    }

    public Author getAuthorById(Long id) {
        return null;
    }
}
