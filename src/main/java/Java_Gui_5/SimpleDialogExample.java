package Java_Gui_5;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class SimpleDialogExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dialog informare");
        alert.setHeaderText("Aveti un mesaj important");
        alert.setContentText("Salut!");

        alert.showAndWait();
    }
}
