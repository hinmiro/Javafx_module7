package CurrencyConverter.datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MariadbConnection {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static EntityManager getInstance() {

        if (em == null) {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("currencyConverter");
            }
            em = emf.createEntityManager();
        }
        return em;
    }
}
