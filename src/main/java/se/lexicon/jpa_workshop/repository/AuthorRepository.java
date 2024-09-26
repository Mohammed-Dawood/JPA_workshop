package se.lexicon.jpa_workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.jpa_workshop.entity.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    // Find authors by their first name
    List<Author> findByFirstName(String firstName);

    // Find authors by their last name
    List<Author> findByLastName(String lastName);

    // Find authors by their first name or last name containing a keyword
    List<Author> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);

    // Find authors by a book's ID
    List<Author> findByWrittenBooks_Id(Integer bookId);


    // Update an author's name by their ID
    @Modifying
    @Query("UPDATE Author a SET a.firstName = :firstName, a.lastName = :lastName WHERE a.id = :id")
    void updateAuthorName(@Param("id") Integer id, @Param("firstName") String firstName, @Param("lastName") String lastName);


    // Delete an author by their ID
    @Modifying
    @Query("DELETE FROM Author a WHERE a.id = :id")
    void deleteAuthorById(@Param("id") Integer id);

}
