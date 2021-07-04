package pl.edu.pjwstk.jazz_s21165_nbp.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;


/* https://api.nbp.pl/api/exchangerates/rates/a/USD/2012-01-01/2012-01-05/?format=json chcemy aby dane wartosci z api byli zmienniane wraz z zapytaniem */
@Entity                                           /* tworzymy obiekt ktory bedzie zawieral te same wartosci co w bazie danych */
public class Tabelki {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "id wyszukania")
    private Long id;
    @ApiModelProperty(notes = "jaka waluta")
    private String waluta;
    @ApiModelProperty(notes = "data od kiedy liczymy")
    private LocalDate dataOd;
    @ApiModelProperty(notes = "data do kiedy liczymy")
    private LocalDate dataDo;
    @ApiModelProperty(notes = "kiedy zostalo wykonane zapytanie")
    private LocalDateTime godzinaSzukania;


   /* @ApiModelProperty(notes = "srednia wyliczone z okreslonego przedzialu++")
    private List<Rate> gotowa ;  /// pewno nie bd dzialac, potrzeba relacji

    */


    public Tabelki() {
    }

    public Tabelki(String waluta, LocalDate dataOd, LocalDate dataDo, LocalDateTime godzinaSzukania) {
        this.waluta = waluta;
        this.dataOd = dataOd;
        this.dataDo = dataDo;
        this.godzinaSzukania = godzinaSzukania;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public LocalDate getDataOd() {
        return dataOd;
    }

    public void setDataOd(LocalDate dataOd) {
        this.dataOd = dataOd;
    }

    public LocalDate getDataDo() {
        return dataDo;
    }

    public void setDataDo(LocalDate dataDo) {
        this.dataDo = dataDo;
    }

    public LocalDateTime getGodzinaSzukania() {
        return godzinaSzukania;
    }

    public void setGodzinaSzukania(LocalDateTime godzinaSzukania) {
        this.godzinaSzukania = godzinaSzukania;
    }
}