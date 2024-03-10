package CurrencyConverter.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    double amount;
    @ManyToOne
    Currency source;

    @ManyToOne
    Currency destination;



    public Transaction(double amount, Currency source, Currency destination) {
        this.amount = amount;
        this.source = source;
        this.destination = destination;

    }

    public Transaction() {
    }

    public Long getId() {
        return id;
    }
}
