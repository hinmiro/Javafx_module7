package CurrencyConverter.Application;

import CurrencyConverter.Dao.CurrencyDao;
import CurrencyConverter.Entity.Currency;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerForAdd {
    @FXML
    private TextField newCurrency;
    @FXML
    private TextField newCurrencyRate;
    private CurrencyConverter gui;
    private Controller cont;

    public void addNewRate() {
        CurrencyDao dao = new CurrencyDao();

        try {
            double rate = Double.parseDouble(newCurrencyRate.getText().replace(",", "."));
            dao.persist(new Currency(rate, newCurrency.getText()));
        } catch (NumberFormatException e) {
            System.out.println("Invalid currency rate");
            newCurrencyRate.clear();
            e.printStackTrace();
            return;
        }
        System.out.println("New currency Added");
        this.cont.updateComboBox();
        gui.closeAddStage();

    }

    public void setGui(CurrencyConverter gui) {
        this.gui = gui;
    }

    public void setCont(Controller con) {
        this.cont = con;
    }
}
