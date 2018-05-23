package Java_Gui_5;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ChoiceBoxExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        List<String> names = new ArrayList<>();
        names.add(" Zakaria");
        names.add("Sarah");
        names.add("Mama");

        ChoiceDialog<String> choiceDialog1 = new ChoiceDialog<>("Zakaria",names);
        choiceDialog1.show();
    }
}
