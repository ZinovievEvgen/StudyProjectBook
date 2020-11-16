package exec.repository;


import exec.models.DimGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DimGenreRepository extends JpaRepository<DimGenre, Long> {
}
