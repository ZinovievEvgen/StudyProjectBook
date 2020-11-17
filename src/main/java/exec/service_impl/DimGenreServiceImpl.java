package exec.service_impl;

import exec.models.DimGenre;
import exec.service.DimGenreService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DimGenreServiceImpl implements DimGenreService {

    @Override
    public List<DimGenre> getAllDimGenre() {
        return null;
    }

    @Override
    public void createDimGenre(DimGenre dimGenre) {

    }

    @Override
    public DimGenre getDimGenreById(Long id) {
        return null;
    }

    //6.4.3.	Вывод статистики Жанр - количество книг
    // (Если не любите Dto для вывода подобной информации посмотрите в сторону аннотации @Formula)
    @Override
    public HashMap<DimGenre, Integer> inputStatisticCountOfBookForGenre(List<DimGenre> dimGenreList) {
        return null;
    }
}
