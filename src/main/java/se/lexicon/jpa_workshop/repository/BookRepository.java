package se.lexicon.jpa_workshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.jpa_workshop.entity.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    // Find book by isbn ignore case.
    Optional<Book> findByIsbnIgnoreCase(String isbn);

    // Find book by title contains.
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Find books with maximum loan days less than a specified number.
    List<Book> findByMaxLoanDaysLessThan(Integer maxLoanDays);
}
