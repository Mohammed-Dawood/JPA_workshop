package se.lexicon.jpa_workshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    @Setter
    private String username;

    @Column(nullable = false, length = 100)
    @Setter
    private String password;

    @Column(nullable = false, length = 25)
    private LocalDateTime regDate;

    // OneToMany relationship with BookLoan
    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookLoan> bookLoans = new ArrayList<>();

    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    private Details userDetails;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.regDate = LocalDateTime.now();
    }

    // Method to add a book loan (bidirectional)
    public void addBookLoan(BookLoan bookLoan) {
        if (!bookLoans.contains(bookLoan)) {
            bookLoans.add(bookLoan);
            bookLoan.setAppUser(this);  // Set the bidirectional link
        }
    }

    // Method to remove a book loan
    public void removeBookLoan(BookLoan bookLoan) {
        if (bookLoans.contains(bookLoan)) {
            bookLoans.remove(bookLoan);
            bookLoan.setAppUser(null);  // Break the bidirectional link
        }
    }

}