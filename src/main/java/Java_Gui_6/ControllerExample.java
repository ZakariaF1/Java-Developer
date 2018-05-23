package Java_Gui_6;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class ControllerExample {

    @FXML      // Adnotarea ( @FXML ) este pentru ai spune instantei ( Label ) ca are valoarea sau obiectul in FXML
    private Label infoMessage;

    @FXML
    private void functie1(Event event) {
        System.out.println("ANA ARE MERE");
        infoMessage.setText("SALUT");
    }
}
