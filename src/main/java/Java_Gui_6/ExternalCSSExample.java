package Java_Gui_6;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ExternalCSSExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(new URL("file:src/main/java/Java_Gui_6/externalcss.fxml"));      // Cream ( Parent ) si incarcam fisierul ( FXML ) folosind ( FXMLLoader )


        Scene scene = new Scene(root);
        scene.getStylesheets().add(new URL("file:src/main/java/Java_Gui_6/style.css").toExternalForm());    // Adaugam scenei toate designul de la ( Stylesheets )

        primaryStage.setTitle("External CSS Example");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
