package CurrencyConverter.Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CurrencyConverter extends Application {
    private Stage add;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/currencyConverterGui.fxml"));
        Parent root =fxmlLoader.load();

        Controller controller = fxmlLoader.getController();
        controller.setGui(this);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showNewStage(Controller con) throws IOException {
        add = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/addStage.fxml"));
        Parent root = fxmlLoader.load();

        ControllerForAdd controllerForAdd = fxmlLoader.getController();
        controllerForAdd.setGui(this);
        controllerForAdd.setCont(con);

        add.setScene(new Scene(root));
        add.initModality(Modality.APPLICATION_MODAL);
        add.showAndWait();
    }

    public void closeAddStage() {
        add.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
