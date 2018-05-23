package Java_Gui_5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TitledPaneExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TitledPane gridTitlePane = new TitledPane();             // Cream un ( TitledPane )
        gridTitlePane.setContent(new Label("Ana are mere"));
        gridTitlePane.setText("Label:");
        gridTitlePane.setExpanded(false);

        TitledPane gridTitlePane2 = new TitledPane();
        gridTitlePane2.setContent(new Button("Apasa"));
        gridTitlePane2.setText("Button:");

        VBox vBox = new VBox();
        vBox.getChildren().addAll(gridTitlePane, gridTitlePane2);

        Scene scene = new Scene(vBox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
