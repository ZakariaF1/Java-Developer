package Java_Gui_5;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class EventHandlerKey extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox();

        TextField textField = new TextField();
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {       // Evenimentul pentru apasarea pe ( keybord ) o litera sau un text
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getText());              // Pentru a afisa litera apasata
                if(event.getCode().equals(KeyCode.ENTER)) {       // Daca codul tiparit este egal cu ( Enter )
                    System.out.println("S-a apasat enter");
                }
            }
        });
        vBox.getChildren().add(textField);

        Scene scene = new Scene(vBox, 300, 300);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
