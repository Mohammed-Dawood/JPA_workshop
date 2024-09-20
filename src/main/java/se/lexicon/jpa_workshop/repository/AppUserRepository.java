package se.lexicon.jpa_workshop.repository;

import se.lexicon.jpa_workshop.entity.AppUser;
import se.lexicon.jpa_workshop.entity.Details;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    // Basic CRUD Operations. done

    // Find a user by Username.
    Optional<AppUser> findByUsername(String username);

    // Find users by registration date between two specific dates.
    List<AppUser> findByRegDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Find users by details id.
    Optional<AppUser> findByDetails_Id(Integer detailsId);

    // Find user by email ignore case.
    Optional<AppUser> findByDetails_EmailIgnoreCase(String email);

    // (Optional)Add more as needed.

}
