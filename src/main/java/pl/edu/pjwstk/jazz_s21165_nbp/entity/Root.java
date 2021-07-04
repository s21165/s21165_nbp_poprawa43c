package pl.edu.pjwstk.jazz_s21165_nbp.entity;

/* aby uzyskac api w json dodajemy na koncu /?forrmat=json    https://api.nbp.pl/api/exchangerates/rates/a/USD/2012-01-01/2012-01-05/?format=json */

import java.util.List;

public class Root{
    public String table;
    public String no;
    public String effectiveDate;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public Root(String table) {
        this.table = table;
    }

    public Root(String table, String no, String effectiveDate, List<Rate> rates) {
        this.table = table;
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.rates = rates;
    }

    public List<Rate> rates;
}
