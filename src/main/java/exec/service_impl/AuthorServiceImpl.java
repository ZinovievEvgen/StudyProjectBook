package exec.service_impl;

import exec.models.Author;
import exec.models.Book;
import exec.repository.AuthorRepository;
import exec.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository repository;

    @Override
    public List<Author> getAllAuthor() {
        return repository.findAll();
    }

    @Override
    public List<Book> getListOfBookForAuthor(Long id) {
        //автор + книги + жанры
        Optional<Author> currentAuthor = repository.findById(id);
        if (currentAuthor.isPresent()) {
            return currentAuthor.get().getBookListOfAuthor();
        } else return Collections.emptyList();
    }

    @Override
    public Author createAuthorWithBooks(Author author) {
        // с книгами или беза, втор + книги
        return null;
    }

    @Override
    public Author updateAuthor(Long id, Author currentAuthor) {
        return repository.findById(id).map(author -> {
            author.setFirstNameOfAuthor(currentAuthor.getFirstNameOfAuthor());
            author.setLastNameOfAuthor(currentAuthor.getLastNameOfAuthor());
            author.setMiddleNameOfAuthor(currentAuthor.getMiddleNameOfAuthor());
            author.setBookListOfAuthor(currentAuthor.getBookListOfAuthor());
            return repository.save(author);
        }).orElseGet(() -> {
            currentAuthor.setIdOfAuthor(id);
            return repository.save(currentAuthor);
        });
    }

    @Override
    public Author createAuthor(Author author) {
        return repository.save(author);
    }

    @Override
    public void deleteAuthorById(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            out.println("Автор содержит записи о книгах в БД!! " + e.getMessage());
        }
    }

    @Override
    public Author getAuthorById(Long id) {
        Optional<Author> author = repository.findById(id);
        if (author.isPresent()) {
            return author.get();
        } else {
            return null;
        }
    }
}
