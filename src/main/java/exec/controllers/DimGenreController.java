package exec.controllers;

import exec.models.DimGenre;
import exec.service.DimGenreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/genre")
@Api(value = "/api/genre", tags = {"Контроллер сущности DimGenre(Жанры)"})
public class DimGenreController {

    @Autowired
    private DimGenreService dimGenreService;

    @GetMapping("/allGenres")
    @ApiOperation(value = "Вывести все жанры без книг")
    public List<DimGenre> getAllGenreWithoutBook() {
        return dimGenreService.getAllGenreWithoutBook();
    }

    @PostMapping("/create")
    @ApiOperation(value = "Создать сущность dimGenre")
    public DimGenre createDimGenre(@RequestBody DimGenre dimGenre) {
        return dimGenreService.createDimGenre(dimGenre);
    }

    @GetMapping("/count-book")
    @ApiOperation(value = "Вывести количество книг по жанрам")
    Map<DimGenre, Long> inputStatisticCountOfBookForGenre() {
        return dimGenreService.inputStatisticCountOfBookForGenre();
    }
}
