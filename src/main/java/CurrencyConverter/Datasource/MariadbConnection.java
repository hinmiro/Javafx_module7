package CurrencyConverter.Datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariadbConnection {
    private static Connection con = null;

    public static Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection("jdbc:mariadb://localhost/currencyconverter?user=appuser&password=appuser");
            } catch (SQLException e) {
                System.out.println("Connection failed");
                e.printStackTrace();
            }
            return con;
        } else
            return con;
    }

    public static void terminateConnection() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
