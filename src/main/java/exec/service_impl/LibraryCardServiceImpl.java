package exec.service_impl;

import exec.repository.LibraryCardRepository;
import exec.service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryCardServiceImpl implements LibraryCardService {

    @Autowired
    private LibraryCardRepository libraryCardRepository;


}
