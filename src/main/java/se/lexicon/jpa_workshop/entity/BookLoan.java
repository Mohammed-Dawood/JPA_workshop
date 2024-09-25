package se.lexicon.jpa_workshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate LoanDate;

    @Column(nullable = false)
    private LocalDate returned;

    @ManyToOne
    private AppUser borrower;

    @ManyToOne
    private Book book;

    public BookLoan(LocalDate loanDate, LocalDate returned, AppUser borrower, Book book) {
        LoanDate = loanDate;
        this.returned = returned;
        this.borrower = borrower;
        this.book = book;
    }
}
