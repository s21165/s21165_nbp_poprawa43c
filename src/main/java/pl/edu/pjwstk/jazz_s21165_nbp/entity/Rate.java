package pl.edu.pjwstk.jazz_s21165_nbp.entity;


/* piersze klasy ktore tworzymy, wiemy jakie maja miec konstruktory poprzez transformacje json to pojo link:https://json2csharp.com/json-to-pojo?fbclid=IwAR18wGu4bkJJoyYO_1z_srqb1ARu5oJFXyCh_mxFAek3A4TaKvE5Rvyw6hU */

public class Rate {
    private String currency;
    private String code;
    private double mid;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    public Rate(String currency, String code, double mid) {
        this.currency = currency;
        this.code = code;
        this.mid = mid;
    }

    public Rate() {
    }
}

