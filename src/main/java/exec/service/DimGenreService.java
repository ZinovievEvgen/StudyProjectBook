package exec.service;


import exec.models.DimGenre;

import java.util.HashMap;
import java.util.List;

public interface DimGenreService {

    List<DimGenre> getAllDimGenre();

    void createDimGenre(DimGenre dimGenre);

    DimGenre getDimGenreById(Long id);

    HashMap<DimGenre, Integer> inputStatisticCountOfBookForGenre(List<DimGenre> dimGenreList);
}
