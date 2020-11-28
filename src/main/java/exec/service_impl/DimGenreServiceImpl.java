package exec.service_impl;

import exec.models.DimGenre;
import exec.repository.DimGenreRepository;
import exec.service.DimGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DimGenreServiceImpl implements DimGenreService {

    @Autowired
    private DimGenreRepository dimGenreRepository;

    @Override
    public List<DimGenre> getAllGenreWithoutBook() {
        return dimGenreRepository.findAll();
    }

    @Override
    public DimGenre createDimGenre(DimGenre dimGenre) {
        return dimGenreRepository.save(dimGenre);
    }

    @Override
    public Map<DimGenre, Long> inputStatisticCountOfBookForGenre() {
        Map<DimGenre, Long> countMapOfBook = new HashMap<>();
        List<DimGenre> list = dimGenreRepository.findAll();
        for (DimGenre aList : list) {
            countMapOfBook.put(aList, aList.getCountOfBook());
        }
        return countMapOfBook;
    }
}
