package CurrencyConverter.Dao;

import CurrencyConverter.Datasource.MariadbConnection;

import java.sql.*;

public class CurrencyDao {
    private double currencyFrom, currencyTo;
    private double amountTo;
    private final double eur = 1;
    private double baseamount;

    public double getCurrencyRate(String currency) {
        Connection con = MariadbConnection.getConnection();
        String sql = "SELECT rate FROM currency WHERE name=?";
        double rate = 0.0;

        try {
            Statement s = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, currency);

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                rate = result.getDouble(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rate;
    }

    public double getAmount(double amount, String from, String to) {
        currencyFrom = getCurrencyRate(from);
        currencyTo = getCurrencyRate(to);
        baseamount = amount /currencyFrom;
        return baseamount * currencyTo;
    }
}
