package Java_Gui_5;

import javafx.application.Application;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Optional;

public class TextInputDialogExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextInputDialog textInputDialog = new TextInputDialog();     // Cream un ( Dialog ) de tip Text
        textInputDialog.setContentText("Introdu parola:");
        textInputDialog.setHeaderText(null);

        Optional<String> result = textInputDialog.showAndWait();
        System.out.println(result.get());               //afisam in consola ce a introdus utilizatorul
    }
}
