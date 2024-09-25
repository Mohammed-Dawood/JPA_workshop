package se.lexicon.jpa_workshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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

    @Setter
    @OneToOne
    private Details userDetails;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.regDate = LocalDateTime.now();
    }
}