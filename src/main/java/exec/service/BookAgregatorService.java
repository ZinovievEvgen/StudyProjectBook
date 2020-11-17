package exec.service;

import exec.models.BookAgregator;

import java.util.List;

public interface BookAgregatorService {

    List<BookAgregator> createBookAgregator(BookAgregator bookAgregator);
    List<BookAgregator> getBookAgregators();
}
