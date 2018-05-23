package Java_Gui_5;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import javax.swing.text.html.Option;
import java.util.Optional;

public class ConfirmationDialogExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);      // Cream un popup alerta si alegem tipul
        alert.setTitle("Dialog informare");
        alert.setHeaderText("Aveti un mesaj important");
        alert.setContentText("Salut!");

        Optional<ButtonType> result = alert.showAndWait();   // Un container de tip ( Button Type )
        if(result.isPresent()) {                             // Daca a fost pasat un ( Button Type )
            System.out.println(result.get());
        }
    }
}
