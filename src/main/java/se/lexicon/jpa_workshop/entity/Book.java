package se.lexicon.jpa_workshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String isbn;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private Integer maxLoanDays;

    @ManyToMany(mappedBy = "writtenBooks",fetch = FetchType.EAGER)
    private Set<Author> authors;

    public Book(String isbn, String title, Integer maxLoanDays) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }
}
