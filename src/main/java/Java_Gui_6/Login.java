package Java_Gui_6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(new URL("file:src/main/java/Java_Gui_6/login.fxml"));


        Scene scene = new Scene(root);

        primaryStage.setTitle("Login fancy!!!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
