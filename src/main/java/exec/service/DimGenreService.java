package exec.service;


import exec.models.DimGenre;

import java.util.List;
import java.util.Map;

public interface DimGenreService {

    List<DimGenre> getAllDimGenre();

    void createDimGenre(DimGenre dimGenre);

    DimGenre updatePerson(DimGenre dimGenre);

    DimGenre getDimGenreById(Long id);

    Map<DimGenre, Integer> inputStatisticCountOfBookForGenre(List<DimGenre> dimGenreList);
}
