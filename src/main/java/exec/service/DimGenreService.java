package exec.service;


import exec.models.DimGenre;

import java.util.List;

public interface DimGenreService {

    DimGenre getDimGenreById(Long id);

    void addDimGenre(DimGenre dimGenre);

    List<DimGenre> getAllDimGenre();

    void deleteDimGenreById(Long id);

    void updateDimGenre(DimGenre dimGenre);
}
