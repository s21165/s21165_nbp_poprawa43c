package pl.edu.pjwstk.jazz_s21165_nbp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.jazz_s21165_nbp.entity.Tabelki;
import pl.edu.pjwstk.jazz_s21165_nbp.service.TabelkiSerwis;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TabelkaKontroller {

    private final TabelkiSerwis tabelkiSerwis;

    public TabelkaKontroller(TabelkiSerwis tabelkiSerwis) {
        this.tabelkiSerwis = tabelkiSerwis;
    }


    @GetMapping("/{waluta}")
    public ResponseEntity<Tabelki> dajPieniadze(

            @PathVariable String waluta,
            @RequestParam String dataOd,
            @RequestParam String dataDo) {
        return ResponseEntity.ok(tabelkiSerwis.dajTabelke(waluta, dataOd, dataDo));
    }


    @GetMapping("/wszystkie")
    public ResponseEntity<List<Tabelki>> findAllCurrency() {
        return ResponseEntity.ok(tabelkiSerwis.findAll());
    }

}

