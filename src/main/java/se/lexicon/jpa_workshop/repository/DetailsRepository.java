package se.lexicon.jpa_workshop.repository;

import se.lexicon.jpa_workshop.entity.Details;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DetailsRepository extends CrudRepository<Details, Integer> {

    // Basic CRUD Operations. done

    // Find a details by email.
    Optional<Details> findByEmail(String email);

    // Find details by name contains.
    Optional<Details> findByNameContaining(String username);

    // Find details by name ignore-case.
    Optional<Details> findByNameIgnoreCase(String username);

    // (Optional) Add more as needed.

}
