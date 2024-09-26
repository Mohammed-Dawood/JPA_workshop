package se.lexicon.jpa_workshop.repository;

import se.lexicon.jpa_workshop.entity.AppUser;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    // Basic CRUD Operations. done

    // Find a user by Username.
    Optional<AppUser> findByUsername(String username);

    // Find users by registration date between two specific dates.
    List<AppUser> findByRegDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Find users by details id.
    Optional<AppUser> findByUserDetails_Id(Integer detailsId);

    // Find user by email ignore case.
    //Optional<AppUser> findByUserDetails_EmailIgnoreCase(String email);

    // (Optional)Add more as needed.
}
