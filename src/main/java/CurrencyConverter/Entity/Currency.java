package CurrencyConverter.Entity;

public class Currency {
    private double rate;
    private String name;

    public Currency(double rate, String name) {
        this.name = name;
        this.rate = rate;
    }

    public double getRate() {
        return this.rate;
    }
}
