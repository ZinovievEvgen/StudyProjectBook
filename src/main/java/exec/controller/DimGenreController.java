package exec.controller;

import exec.models.DimGenre;
import exec.service.DimGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = {"/api/dimGenre"})
public class DimGenreController {

    @Autowired
    private DimGenreService dimGenreService;

    @GetMapping("/allDimGenre")
    public List<DimGenre> getAllDimGenre() {
        return dimGenreService.getAllDimGenre();
    }

    @PostMapping(value = "/create")
    public void createDimGenre(DimGenre dimGenre) {
        dimGenreService.createDimGenre(dimGenre);
    }

    @GetMapping("/get/{id}")
    public DimGenre getDimGenreById(@PathVariable Long id) {
        return dimGenreService.getDimGenreById(id);
    }

    @GetMapping("/getCount/{id}")
    public Map<DimGenre, Integer> inputStatisticCountOfBookForGenre(@PathVariable Long id) {
        return null;
    }
}
