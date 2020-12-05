package exec.controllers;

import exec.models.DimGenre;
import exec.service.DimGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/genre")
public class DimGenreController {

    @Autowired
    private final DimGenreService dimGenreService;

    public DimGenreController(DimGenreService dimGenreService) {
        this.dimGenreService = dimGenreService;
    }

    @GetMapping("/allGenres")
    public List<DimGenre> getAllGenreWithoutBook() {
        return dimGenreService.getAllGenreWithoutBook();
    }

    @PostMapping("/create")
    public DimGenre createDimGenre(@RequestBody DimGenre dimGenre) {
        return dimGenreService.createDimGenre(dimGenre);
    }

    @GetMapping("/count-book")
    Map<DimGenre, Long> inputStatisticCountOfBookForGenre() {
        return dimGenreService.inputStatisticCountOfBookForGenre();
    }
}
