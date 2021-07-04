package pl.edu.pjwstk.jazz_s21165_nbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjwstk.jazz_s21165_nbp.entity.Tabelki;

public interface PoprawaRepo extends JpaRepository<Tabelki, Long> {   /* dzieki temu mamy dostep do podstawowych operacji takie jak findbyid, findall, save, delete by id */
    /* model ktory laczy sie z baza danych oraz Long jako id */
}
