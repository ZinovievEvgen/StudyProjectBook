package exec.models;

import java.io.Serializable;

/**
 * Слой сущностей БД (Model)
 * класс-BookAgregator: содержит информацию о книгах, выданных в пользование
 */
public class BookAgregator implements Serializable {

    private Long idOfBookAgregator;
    private Person person;
    private String dateToGiveBook;

    public BookAgregator() {
    }

    public Long getIdOfBookAgregator() {
        return idOfBookAgregator;
    }

    public void setIdOfBookAgregator(Long idOfBookAgregator) {
        this.idOfBookAgregator = idOfBookAgregator;
    }

    public String getDateToGiveBook() {
        return dateToGiveBook;
    }

    public void setDateToGiveBook(String dateToGiveBook) {
        this.dateToGiveBook = dateToGiveBook;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookAgregator that = (BookAgregator) o;

        if (idOfBookAgregator != null ? !idOfBookAgregator.equals(that.idOfBookAgregator) : that.idOfBookAgregator != null)
            return false;
        if (person != null ? !person.equals(that.person) : that.person != null) return false;
        return dateToGiveBook != null ? dateToGiveBook.equals(that.dateToGiveBook) : that.dateToGiveBook == null;

    }

    @Override
    public int hashCode() {
        int result = idOfBookAgregator != null ? idOfBookAgregator.hashCode() : 0;
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (dateToGiveBook != null ? dateToGiveBook.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookAgregator{" +
                "idOfBookAgregator=" + idOfBookAgregator +
                ", person=" + person +
                ", dateToGiveBook='" + dateToGiveBook + '\'' +
                '}';
    }
}
