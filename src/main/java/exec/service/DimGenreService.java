package exec.service;


import exec.models.DimGenre;

import java.util.List;
import java.util.Map;

public interface DimGenreService {

    List<DimGenre> getAllGenreWithoutBook();

    DimGenre createDimGenre(DimGenre dimGenre);

    Map<DimGenre, Long> inputStatisticCountOfBookForGenre();
}
