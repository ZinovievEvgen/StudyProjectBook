package exec.init;


import exec.models.Author;
import exec.models.Book;
import exec.models.DimGenre;
import exec.models.Person;
import exec.service.AuthorService;
import exec.service.BookService;
import exec.service.DimGenreService;
import exec.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@Component
public class DataLoader implements CommandLineRunner {


    private final PersonService personService;
    private final DimGenreService dimGenreService;
    private final BookService bookService;
    private final AuthorService authorService;


    public DataLoader(PersonService personService, DimGenreService dimGenreService, BookService bookService, AuthorService authorService) {
        this.personService = personService;
        this.dimGenreService = dimGenreService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... strings) throws Exception {
        initData();
    }

    private void initData() {
        out.println("exec.init data");

        DimGenre genre1 = new DimGenre();
        genre1.setGenreName("Фентези");
        dimGenreService.createDimGenre(genre1);
        DimGenre genre2 = new DimGenre();
        genre2.setGenreName("Исторический");
        dimGenreService.createDimGenre(genre2);
        DimGenre genre3 = new DimGenre();
        genre3.setGenreName("Классика");
        dimGenreService.createDimGenre(genre3);

        List<DimGenre> list1 = new ArrayList<>();
        list1.add(genre1);

        List<DimGenre> list2 = new ArrayList<>();
        list2.add(genre1);
        list2.add(genre2);

        List<DimGenre> list3 = new ArrayList<>();
        list3.add(genre3);

        Author author1 = authorService.createAuthor(new Author("Федоров", "Федор", "Федорович"));
        Author author2 = authorService.createAuthor(new Author("Романов", "Роман", "Федорович"));
        Author author3 = authorService.createAuthor(new Author("Павлов", "Павел", "Федорович"));
        Author author4 = authorService.createAuthor(new Author("Николаев", "Николай", "Федорович"));
        Author author5 = authorService.createAuthor(new Author("Лермонтов", "Михаил", "Федорович"));

        Book book1 = new Book();
        book1.setNameOfBook("История одного прогера");
        book1.setGenres(list1);
        book1.setAuthorOfBook(author1);
        bookService.createBook(book1);

        Book book2 = new Book();
        book2.setNameOfBook("Туда  и обратно мистер Дюк");
        book2.setGenres(list2);
        book2.setAuthorOfBook(author2);
        bookService.createBook(book2);


        Book book3 = new Book();
        book3.setNameOfBook("ЧТО ГДЕ КУДА! JUNIOR");
        book3.setGenres(list3);
        book3.setAuthorOfBook(author3);
        bookService.createBook(book3);

        Book book4 = new Book();
        book4.setNameOfBook("Мцыри");
        book4.setGenres(list3);
        book4.setAuthorOfBook(author5);
        bookService.createBook(book4);

        Person person1 = new Person();
        person1.setFirstName("Иван");
        person1.setLastName("Иванов");
        person1.setMiddleName("Иванович");
        person1.setBirthDate(LocalDate.now());
        personService.createPerson(person1);

        Person person2 = new Person();
        person2.setFirstName("Семен");
        person2.setLastName("Семенов");
        person2.setMiddleName("Семенович");
        person2.setBirthDate(LocalDate.now());
        personService.createPerson(person2);

        Person person3 = new Person();
        person3.setFirstName("Петр");
        person3.setLastName("Петров");
        person3.setMiddleName("Петрович");
        person3.setBirthDate(LocalDate.now());
        personService.createPerson(person3);
    }
}
