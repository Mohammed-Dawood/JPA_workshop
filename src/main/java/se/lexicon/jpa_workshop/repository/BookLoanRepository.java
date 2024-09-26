package se.lexicon.jpa_workshop.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.jpa_workshop.entity.BookLoan;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {

    // Find book loans by borrower's ID.
    List<BookLoan> findByBorrower_Id(Integer borrowerId);

    // Find book loans by book ID.
    List<BookLoan> findByBook_Id(Integer bookId);

    // Find book loans that are not yet returned.
    List<BookLoan> findByReturnedIsNull();

    // Find overdue book loans (due date is past and not returned).
    List<BookLoan> findByReturnedIsNullAndReturnedBefore(LocalDate returnedBefore);

    // Find book loans between specified dates.
    //List<BookLoan> findByLoanDateBetween(LocalDate startDate, LocalDate endDate);

    // Mark a book loan as returned by its loan ID.

}
