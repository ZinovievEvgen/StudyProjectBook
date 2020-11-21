package exec.service_impl;

import exec.models.DimGenre;
import exec.repository.DimGenreRepository;
import exec.service.DimGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DimGenreServiceImpl implements DimGenreService {

    @Autowired
    private DimGenreRepository repository;

    @Override
    public List<DimGenre> getAllDimGenre() {
        return repository.findAll();
    }

    @Override
    public void createDimGenre(DimGenre dimGenre) {
        repository.save(dimGenre);
    }

    @Override
    public DimGenre getDimGenreById(Long id) {
        Optional<DimGenre> genre = repository.findById(id);
        if (genre.isPresent()) {
            return genre.get();
        } else {
            return null;
        }
    }

    //6.4.3.	Вывод статистики Жанр - количество книг
    // (Если не любите Dto для вывода подобной информации посмотрите в сторону аннотации @Formula)
    @Override
    public Map<DimGenre, Integer> inputStatisticCountOfBookForGenre(List<DimGenre> dimGenreList) {
        return null;
    }
}
