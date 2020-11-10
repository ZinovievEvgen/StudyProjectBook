package exec.models;

import java.io.Serializable;

/**
 * Слой сущностей БД (Model)
 * класс-Book: содержит информацию о книгах
 */
public class Book implements Serializable {

    private Long idOfBook;
    private String titleOfBook;
    private String authorOfBook;
    private String styleOfBook;

    public Book() {
    }


    public Book(Long idOfBook, String titleOfBook, String authorOfBook, String styleOfBook) {
        this.idOfBook = idOfBook;
        this.titleOfBook = titleOfBook;
        this.authorOfBook = authorOfBook;
        this.styleOfBook = styleOfBook;
    }

    public Long getIdOfBook() {
        return idOfBook;
    }

    public void setIdOfBook(Long idOfBook) {
        this.idOfBook = idOfBook;
    }

    public String getStyleOfBook() {
        return styleOfBook;
    }

    public void setStyleOfBook(String styleOfBook) {
        this.styleOfBook = styleOfBook;
    }

    public String getAuthorOfBook() {
        return authorOfBook;
    }

    public void setAuthorOfBook(String authorOfBook) {
        this.authorOfBook = authorOfBook;
    }

    public String getTitleOfBook() {
        return titleOfBook;
    }

    public void setTitleOfBook(String titleOfBook) {
        this.titleOfBook = titleOfBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (idOfBook != null ? !idOfBook.equals(book.idOfBook) : book.idOfBook != null) return false;
        if (titleOfBook != null ? !titleOfBook.equals(book.titleOfBook) : book.titleOfBook != null) return false;
        if (authorOfBook != null ? !authorOfBook.equals(book.authorOfBook) : book.authorOfBook != null) return false;
        return styleOfBook != null ? styleOfBook.equals(book.styleOfBook) : book.styleOfBook == null;

    }

    @Override
    public int hashCode() {
        int result = idOfBook != null ? idOfBook.hashCode() : 0;
        result = 31 * result + (titleOfBook != null ? titleOfBook.hashCode() : 0);
        result = 31 * result + (authorOfBook != null ? authorOfBook.hashCode() : 0);
        result = 31 * result + (styleOfBook != null ? styleOfBook.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "titleOfBook='" + titleOfBook + '\'' +
                '}';
    }
}
