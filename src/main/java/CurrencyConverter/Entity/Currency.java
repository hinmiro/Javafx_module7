package CurrencyConverter.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    private int id;
    private double rate;
    private String name;

    public Currency(double rate, String name) {
        this.name = name;
        this.rate = rate;
    }

    public Currency() {

    }

    public double getRate() {
        return this.rate;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}
