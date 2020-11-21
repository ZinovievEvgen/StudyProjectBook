package exec.repository;


import exec.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByFirstNameOfPersonAndLastNameOfPersonAndMiddleNameOfPerson(String nameOfPerson, String lastNameOfPerson, String middleNameOfPerson);
}
