package CurrencyConverter.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double rate;
    private String abbreviation;
    private String name;

    public Currency(double rate, String abbreviation, String name) {
        this.name = name;
        this.rate = rate;
        this.abbreviation = abbreviation;
    }

    public Currency() {

    }

    public double getRate() {
        return this.rate;
    }

    public String getName() {
        return this.name;
    }

    public String getAbbreviation() {return this.abbreviation;};

    public long getId() {
        return this.id;
    }
}
