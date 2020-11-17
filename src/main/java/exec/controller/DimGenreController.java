package exec.controller;

import exec.models.DimGenre;
import exec.service.DimGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = {"/api/dimGenre"})
public class DimGenreController {

    @Autowired
    private DimGenreService dimGenreService;

    public List<DimGenre> getAllDimGenre() {
        return null;
    }

    public void createDimGenre(DimGenre dimGenre) {

    }

    public DimGenre getDimGenreById(Long id) {
        return null;
    }

    //6.4.3.	Вывод статистики Жанр - количество книг
    // (Если не любите Dto для вывода подобной информации посмотрите в сторону аннотации @Formula)
    public HashMap<DimGenre, Integer> inputStatisticCountOfBookForGenre(List<DimGenre> dimGenreList) {
        return null;
    }
}
