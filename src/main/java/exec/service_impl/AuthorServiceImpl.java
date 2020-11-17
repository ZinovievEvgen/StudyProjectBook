package exec.service_impl;

import exec.models.Author;
import exec.models.Book;
import exec.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Override
    public List<Author> getAllAuthor() {
        return null;
    }

    //автор + книги + жанры
    @Override
    public List<Book> getListOfBookForAuthor(Author author) {
        return null;
    }

    // с книгами или беза, втор + книги
    @Override
    public Author createAuthor(Author author) {
        return null;
    }


    // (если только нет книг, иначе кидать ошибку с пояснением,
    // что нельзя удалить автора пока есть его книги) - Ок или Ошибка
    @Override
    public void deleteAuthorById(Long id) {

    }

    @Override
    public Author getAuthorById(Long id) {
        return null;
    }
}
