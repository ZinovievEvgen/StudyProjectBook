package exec.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * Слой сущностей БД (Model)
 * класс-BookAgregator: содержит информацию о книгах, выданных в пользование
 */
public class BookAgregator implements Serializable {

    private Person person;
    private Book book;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX")
    //yyyy-MM-dd@HH:mm:ss.SSSZ
    private ZonedDateTime dateToGiveBook;

    public BookAgregator() {
    }

    public ZonedDateTime getDateToGiveBook() {
        return dateToGiveBook;
    }

    public void setDateToGiveBook(ZonedDateTime dateToGiveBook) {
        this.dateToGiveBook = dateToGiveBook;
    }

    public Person getPerson() {
        return person;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
