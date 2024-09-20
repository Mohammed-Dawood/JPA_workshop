package se.lexicon.jpa_workshop.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.jpa_workshop.entity.Details;

import java.time.LocalDate;

@DataJpaTest
public class DetailsRepositoryTest {

    @Autowired
    DetailsRepository detailsRepository;

    @Test
    @Transactional
    public void testSaveAndFindById() {
        //1. Arrange
        Details details = new Details("m.dawood.780909@gmail.com", "Mohammed Dawood", LocalDate.of(1978, 9, 9));
        //2. Act
        Details savedDetails = detailsRepository.save(details);
        //3. Assert
        Assertions.assertNotNull(savedDetails);
        Assertions.assertNotNull(savedDetails.getEmail());
    }
}
