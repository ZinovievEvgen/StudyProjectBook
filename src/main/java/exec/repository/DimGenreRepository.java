package exec.repository;


import exec.models.DimGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimGenreRepository extends JpaRepository<DimGenre, Long> {

    DimGenre findByGenreName(String nameOfDimGenre);
}
