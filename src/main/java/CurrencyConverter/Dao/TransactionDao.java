package CurrencyConverter.Dao;

import CurrencyConverter.Entity.Transaction;
import CurrencyConverter.datasource.MariadbConnection;
import jakarta.persistence.EntityManager;

public class TransactionDao {
    EntityManager em = MariadbConnection.getInstance();


    public void persist(Transaction t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

    public Transaction find(long id) {
        Transaction t = em.find(Transaction.class, id);
        return t;
    }
}
