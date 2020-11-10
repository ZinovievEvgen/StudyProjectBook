package exec.service;

import exec.models.BookAgregator;

import java.util.Date;
import java.util.List;

public interface BookAgregatorService {

    List<BookAgregator> createBookAgregator(BookAgregator bookAgregator, Date date);
    List<BookAgregator> getBookAgregators();
}
