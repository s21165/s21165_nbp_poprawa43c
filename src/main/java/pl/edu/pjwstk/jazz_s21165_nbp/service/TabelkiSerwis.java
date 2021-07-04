package pl.edu.pjwstk.jazz_s21165_nbp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.edu.pjwstk.jazz_s21165_nbp.entity.Rate;
import pl.edu.pjwstk.jazz_s21165_nbp.entity.Root;
import pl.edu.pjwstk.jazz_s21165_nbp.entity.Tabelki;
import pl.edu.pjwstk.jazz_s21165_nbp.repository.PoprawaRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Service  /* "Service objects provide the client view of a Web service" tutaj bedzie logika aplikacji umozliwiajaca komunikacje, szuka @RestController, oraz @Contrroller */
public class TabelkiSerwis {
    private final RestTemplate restTemplate;   /* BEAN */
    private final PoprawaRepo averageRepo;  /* JPA */

    public TabelkiSerwis(RestTemplate restTemplate, PoprawaRepo averageRepo) {
        this.restTemplate = restTemplate;
        this.averageRepo = averageRepo;
    }


        public Tabelki dajTabelke (String waluta, String dataOd, String dataDo){
            Root[] ulotneTabelki = restTemplate.getForObject("https://api.nbp.pl/api/exchangerates/tables/a/" + dataOd + "/" + dataDo + "/?format=json", Root[].class);
            List<Rate> listaGotowa = new ArrayList<>();

            for (Root nbpRoot : ulotneTabelki) {
                for (Rate rate : nbpRoot.getRates()) {
                    if (rate.getCode() == waluta.toUpperCase(Locale.ROOT)) {
                        listaGotowa.add(rate);

                    }
                }
            }

            LocalDate dataFormatowanaOd = LocalDate.parse(dataOd);    /* formatujemy date */
            LocalDate dataFormatowanaDo = LocalDate.parse(dataDo);

//String waluta, LocalDate dataOd, LocalDate dataDo, LocalDateTime godzinaSzukania
            return (new Tabelki(waluta,dataFormatowanaOd,dataFormatowanaDo,LocalDateTime.now() ));
        }

    public List<Tabelki> findAll() {
        return averageRepo.findAll();
    }


    }
