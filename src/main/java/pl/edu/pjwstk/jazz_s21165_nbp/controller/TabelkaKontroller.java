package pl.edu.pjwstk.jazz_s21165_nbp.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation(value = "Get average exchange rate",
            response = Tabelki.class,
            notes = "This method will return average exchange rate in date range")
    @GetMapping("/{waluta}")
    public ResponseEntity<Tabelki> dajPieniadze(
            @ApiParam(
                    name = "waluta",
                    type = "String",
                    value = "wybierz walute",
                    example = "EUR",
                    required = true,
                    defaultValue = "GBP")
            @PathVariable String waluta,
            @ApiParam(
                    name = "dataOd",
                    type = "String",
                    value = "data od kiedy ma liczyc",
                    example = "2016-01-02",
                    required = true,
                    defaultValue = "GBP")
            @RequestParam String dataOd,
            @ApiParam(
                    name = "dataDo",
                    type = "String",
                    value = "Data do kiedy ma liczyc",
                    example = "2016-01-06",
                    required = true,
                    defaultValue = "GBP")
            @RequestParam String dataDo) {
        return ResponseEntity.ok(tabelkiSerwis.dajTabelke(waluta, dataOd, dataDo));
    }


    @GetMapping("/wszystkie")
    public ResponseEntity<List<Tabelki>> findAllCurrency() {
        return ResponseEntity.ok(tabelkiSerwis.findAll());
    }

}

