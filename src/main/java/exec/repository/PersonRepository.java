package exec.repository;


import exec.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByFirstNameAndLastNameAndMiddleName(String name, String lastName, String middleName);
}
