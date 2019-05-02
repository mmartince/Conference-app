package hr.tvz.martincevic.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import hr.tvz.martincevic.entities.Predavac;
import hr.tvz.martincevic.entities.Predavanje;
import hr.tvz.martincevic.entities.repositories.PredavanjeRepository;
import hr.tvz.martincevic.enums.PozicijaPredavaca;
import hr.tvz.martincevic.enums.VrstaPredavanja;

@Component
public class DataLoader implements ApplicationRunner {

	PredavanjeRepository predavanjeRepository;

    @Autowired
    public DataLoader(PredavanjeRepository predavanjeRepository) {
        this.predavanjeRepository = predavanjeRepository;
    }

    public void run(ApplicationArguments args) {
		predavanjeRepository.save(new Predavanje(new Predavac("Ivan", "Koz", PozicijaPredavaca.JUNIOR), "Prva tema", "Prvi sadrzaj", VrstaPredavanja.PREZENTACIJA, false));
		predavanjeRepository.save(new Predavanje(new Predavac("Marko", "Juric", PozicijaPredavaca.JUNIOR), "Druga tema", "Drugi sadrzaj", VrstaPredavanja.PREZENTACIJA, true));
		predavanjeRepository.save(new Predavanje(new Predavac("Karla", "Manic", PozicijaPredavaca.MID), "Treca tema", "Treci sadrzaj", VrstaPredavanja.PREZENTACIJA, false));
		predavanjeRepository.save(new Predavanje(new Predavac("Zdenko", "Benqo", PozicijaPredavaca.SENIOR), "Kako upropastit sve", "Detaljan opis", VrstaPredavanja.RADIONICA, true));
    }
}