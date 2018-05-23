package Java_Gui_5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();         // Un Vbox dar outem pune elementele in 5 locuri ( Top, Right, Bottom, Left, Center )
        borderPane.setCenter(new Label("center"));
        borderPane.setTop(new Label("top"));


        Scene scene = new Scene(borderPane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
