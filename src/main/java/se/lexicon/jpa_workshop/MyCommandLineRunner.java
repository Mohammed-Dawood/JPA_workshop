package se.lexicon.jpa_workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.jpa_workshop.entity.AppUser;
import se.lexicon.jpa_workshop.entity.Details;
import se.lexicon.jpa_workshop.repository.AppUserRepository;
import se.lexicon.jpa_workshop.repository.DetailsRepository;

import java.time.LocalDate;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    DetailsRepository detailsRepository;

    @Override
    public void run(String... args) throws Exception {
        Details userDetails = detailsRepository.save(new Details("Test@Tese.com", "Test", LocalDate.of(1978, 9, 9)));
        appUserRepository.save(new AppUser("Mohammed", "MMMM", userDetails));
    }
}

