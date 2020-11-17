package exec.service_impl;


import exec.models.BookAgregator;
import exec.service.BookAgregatorService;
import exec.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookAgregatorServiceImpl implements BookAgregatorService {

    private List<BookAgregator> bookAgregatorList = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    PersonService personService;

    @Override
    public List<BookAgregator> createBookAgregator(BookAgregator bookAgregator) {

        bookAgregatorList.add(bookAgregator);
        logger.info(String.format("Add bookAgregator%s", bookAgregator));
        return bookAgregatorList;
    }

    @Override
    public List<BookAgregator> getBookAgregators() {
        return bookAgregatorList;
    }
}