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
    private final BookService bookService;
    private final AuthorService authorService;
    private final DimGenreService dimGenreService;


    public DataLoader(PersonService personService, BookService bookService,
                      AuthorService authorService, DimGenreService dimGenreService) {
        this.personService = personService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.dimGenreService = dimGenreService;
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
        list2.add(genre2);

        List<DimGenre> list3 = new ArrayList<>();
        list3.add(genre3);

        Author author1 = authorService.createAuthor(new Author("Федоров", "Федор"));
        Author author2 = authorService.createAuthor(new Author("Романов", "Роман"));
        Author author3 = authorService.createAuthor(new Author("Павлов", "Павел"));
        Author author4 = authorService.createAuthor(new Author("Николаев", "Николай"));

        Book book1 = new Book();
        book1.setNameOfBook("История одного прогера");
        book1.setGenres(list1);
        book1.setAuthorOfBook(author1);

        List<Book> listBook1 = new ArrayList<>();
        listBook1.add(book1);

        bookService.createBook(book1);

        Book book2 = new Book();
        book2.setNameOfBook("Туда  и обратно мистер Дюк");
        book2.setGenres(list2);
        book2.setAuthorOfBook(author2);

        List<Book> listBook2 = new ArrayList<>();
        listBook2.add(book2);

        bookService.createBook(book2);

        Book book3 = new Book();
        book3.setNameOfBook("ЧТО ГДЕ КУДА! JUNIOR");
        book3.setGenres(list3);
        book3.setAuthorOfBook(author3);

        List<Book> listBook3 = new ArrayList<>();
        listBook3.add(book3);

        bookService.createBook(book3);


        Person person1 = new Person();
        person1.setFirstNameOfPerson("Иван");
        person1.setLastNameOfPerson("Иванов");
        person1.setMiddleNameOfPerson("Иванович");
        person1.setBirthDateOfPerson(LocalDate.now());
        person1.setBookListOfPerson(listBook1);
        personService.createPerson(person1);

        Person person2 = new Person();
        person2.setFirstNameOfPerson("Семен");
        person2.setLastNameOfPerson("Семенов");
        person2.setMiddleNameOfPerson("Семенович");
        person2.setBirthDateOfPerson(LocalDate.now());
        person2.setBookListOfPerson(listBook2);
        personService.createPerson(person2);

        Person person3 = new Person();
        person3.setFirstNameOfPerson("Петр");
        person3.setLastNameOfPerson("Петров");
        person3.setMiddleNameOfPerson("Петрович");
        person3.setBirthDateOfPerson(LocalDate.now());
        person3.setBookListOfPerson(listBook3);
        personService.createPerson(person3);
    }
}
