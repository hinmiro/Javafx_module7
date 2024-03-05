package CurrencyConverter.Application;

import CurrencyConverter.Dao.CurrencyDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button clearButton;
    @FXML
    private Button convertButton;
    @FXML
    private ComboBox fromCombo;
    @FXML
    private ComboBox toCombo;
    @FXML
    private TextField amount;
    @FXML
    private TextField converted;
    private double amountDouble;
    private String currencyFrom;
    private String currencyTo;
    private CurrencyDao dao;

    public void initialize() {
        ObservableList<String> options = FXCollections.observableArrayList(
                "EUR",
                "USD",
                "JPY",
                "BGN",
                "CZK",
                "DKK",
                "GBP",
                "PLN",
                "SEK"
        );
        fromCombo.setItems(options);
        toCombo.setItems(options);
        dao = new CurrencyDao();
    }


    public void clear() {
        amount.clear();
        converted.clear();
        convertButton.setDisable(false);
        amountDouble = 0;
    }

    public void convert() {
        try {
            amountDouble = Double.parseDouble(amount.getText());
        } catch (NumberFormatException e) {
            converted.setText("Cannot convert");
            e.printStackTrace();
            return;
        }
        if (fromCombo.getValue() == null || toCombo.getValue() == null) {
            converted.setText("Select currency");
            convertButton.setDisable(true);
            throw new NullPointerException("Select currency");
        }
        currencyFrom = (String) fromCombo.getValue();
        currencyTo = (String) toCombo.getValue();
        double parsAmount = dao.getAmount(amountDouble, currencyFrom, currencyTo);
        converted.setText(String.valueOf(Math.round(parsAmount * 100.00) / 100.00));
    }

    public static void main(String[] args) {
        CurrencyConverter.launch(CurrencyConverter.class);
    }
}
