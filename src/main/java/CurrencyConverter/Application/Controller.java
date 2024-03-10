package CurrencyConverter.Application;

import CurrencyConverter.Dao.CurrencyDao;
import CurrencyConverter.Dao.TransactionDao;
import CurrencyConverter.Entity.Currency;
import CurrencyConverter.Entity.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

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
    private double currencyFrom;
    private double currencyTo;
    private CurrencyDao currencyDao;
    private long count;
    private ArrayList<String> names;
    private CurrencyConverter gui;
    private ControllerForAdd adder;
    private TransactionDao transDao;
    private Currency source, destination;
    private Transaction trans;

    public void initialize() {

        adder = new ControllerForAdd();
        names = new ArrayList<>();
        currencyDao = new CurrencyDao();
        transDao = new TransactionDao();
        populateDatabase();

    }


    public void setGui(CurrencyConverter gui) {
        this.gui = gui;
    }

    public void clear() {
        amount.clear();
        converted.clear();
        convertButton.setDisable(false);
        amountDouble = 0;
    }

    public void convert() {
        try {
            amountDouble = Double.parseDouble(amount.getText().replace(",", "."));


        } catch (NumberFormatException e) {
            converted.setText("Cannot convert");
            e.printStackTrace();
            return;
        }
        if (fromCombo.getValue() == null || toCombo.getValue() == null) {
            converted.setText("Select currency");
            convertButton.setDisable(true);
            throw new IllegalArgumentException("Select currency");
        }
        source = currencyDao.findWithName(fromCombo.getValue().toString());
        destination = currencyDao.findWithName(toCombo.getValue().toString());
        trans = new Transaction(amountDouble, source, destination);
        transDao.persist(trans);
        double parsAmount = getAmount(amountDouble, source.getRate(), destination.getRate());
        BigDecimal amountBigDecimal = new BigDecimal(parsAmount);
        converted.setText(String.valueOf(amountBigDecimal.setScale(3, RoundingMode.HALF_DOWN)));
    }

    public double getAmount(double amount, double from, double to) {
        double baseamount = amount / from;
        return baseamount * to;
    }

    public void addCurrency() {
        try {
            adder.setCont(this);
            gui.showNewStage(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateComboBox() {
        fromCombo.getItems().clear();
        toCombo.getItems().clear();
        names.clear();
        count = currencyDao.howMany();
        for (int i = 0; i < count; i++) {
            names.add(currencyDao.findName(i + 1));
        }
        ObservableList<String> options = FXCollections.observableArrayList();
        options.addAll(names);

        fromCombo.setItems(options);
        toCombo.setItems(options);
    }

    public void populateDatabase() {

        currencyDao.persist(new Currency(1.093, "USD", "US dollar"));
        currencyDao.persist(new Currency(160.99, "JPY", "Japanese yen"));
        currencyDao.persist(new Currency(1, "EUR", "European euro"));
        currencyDao.persist(new Currency(1.6569, "AUD", "Australian dollar"));
        updateComboBox();

    }

    public static void main(String[] args) {
        CurrencyConverter.launch(CurrencyConverter.class);
    }

}
