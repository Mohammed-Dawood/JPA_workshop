package se.lexicon.jpa_workshop.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.jpa_workshop.entity.AppUser;
import se.lexicon.jpa_workshop.entity.Details;


import java.beans.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;

@DataJpaTest
public class AppUserRepositoryTest {

    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    DetailsRepository detailsRepository;

    @Test
    @Transactional
    public void testSaveAndFindById() {

        //1. Arrange
        AppUser appUser = new AppUser("Test", "Test", LocalDateTime.now());
        Details details = new Details("niculescusergiu00@gmail.com", "Mohammed Dawood", LocalDate.of(1978, 9, 9));
        appUser.setUserDetails(details);
        //2. Act
        AppUser savedAppUser = appUserRepository.save(appUser);
        //3. Assert
        Assertions.assertNotNull(savedAppUser);
        Assertions.assertEquals("m.dawood.780909@gmail.com", savedAppUser.getUserDetails().getEmail());
    }

}
