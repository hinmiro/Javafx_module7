package CurrencyConverter.Dao;

import CurrencyConverter.Entity.Currency;
import jakarta.persistence.EntityManager;
import CurrencyConverter.datasource.*;
import jakarta.persistence.NoResultException;

public class CurrencyDao {
    EntityManager em = MariadbConnection.getInstance();


    public void persist(Currency c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    public Currency find(int id) {
        Currency c = em.find(Currency.class, id);
        return c;
    }

    public void delete(Currency c) {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    public void update(Currency c) {
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }

    public long howMany() {
        return (Long) em.createQuery("SELECT COUNT(id) FROM Currency").getSingleResult();
    }

    public String findName(int i) {
        return (String) em.createQuery("SELECT abbreviation FROM Currency WHERE id= :id").setParameter("id", i).getSingleResult();
    }

    public Currency findWithName(String abbreviation) {
        try {
            Currency c = em.createQuery("SELECT c FROM Currency c WHERE c.abbreviation = :abbreviation", Currency.class)
                    .setParameter("abbreviation", abbreviation).getSingleResult();
            return c;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}