package exec.service_impl;

import exec.models.Book;
import exec.models.DimGenre;
import exec.repository.AuthorRepository;
import exec.repository.BookRepository;
import exec.repository.DimGenreRepository;
import exec.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.geom.Dimension2D;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private DimGenreRepository dimGenreRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book createBookWithAuthorAndGenre(Book book, Long idOfAuthor, Long idOfGenre) throws Exception {
        //книга + автор + жанр
        book.setAuthorOfBook(authorRepository.findById(idOfAuthor).orElseThrow(Exception::new));
        List<DimGenre> newList = new ArrayList<>();
        newList.add(dimGenreRepository.findById(idOfGenre).orElseThrow(Exception::new));
        book.setGenres(newList);
        return bookRepository.save(book);
    }


    @Override
    public Book updateBook(Long id, Book newBook) {
        return bookRepository.findById(id).map(book -> {
            book.setNameOfBook(newBook.getNameOfBook());
            book.setPerson(newBook.getPerson());
            book.setAuthorOfBook(newBook.getAuthorOfBook());
            book.setGenres(newBook.getGenres());
            return bookRepository.save(book);
        }).orElseGet(() -> {
            newBook.setIdOfBook(id);
            return bookRepository.save(newBook);
        });
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBookById(Long id) {
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Book> bookForGenre(String nameOfGenre) {
        return bookRepository.findAll().stream().peek(
                        book -> book.getGenres()
                                .stream().filter(dimGenre -> nameOfGenre.equals(dimGenre.getGenreName())))
        .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksForAuthor(String firstNameOfAuthor, String lastNameOfAuthor, String middleNameOfAuthor) {
        return bookRepository.findAll().stream().filter(
                book -> book.getAuthorOfBook().getFirstNameOfAuthor().equals(firstNameOfAuthor)
                        && book.getAuthorOfBook().getLastNameOfAuthor().equals(lastNameOfAuthor)
                        && book.getAuthorOfBook().getMiddleNameOfAuthor().equals(middleNameOfAuthor)
        ).collect(Collectors.toList());
    }

    @Override
    public Book updateGenreForBook(Long id, Book currentBook) {
        //Книга + жанр + автор
        return bookRepository.findById(id).map(book -> {
            book.setGenres(currentBook.getGenres());
            return bookRepository.save(book);
        }).orElseGet(() -> {
            currentBook.setIdOfBook(id);
            return bookRepository.save(currentBook);
        });
    }
}
