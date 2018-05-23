package Java_Gui_5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class EventHandler extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox();

        Button b = new Button("Button");
        b.setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>() {      // Evenimentul pentru apasarea pe ( Button )
            @Override
            public void handle(MouseEvent event) {
                System.out.println("button handler");
                event.consume();         // Pentru trminarea enenimentului
            }
        });
        vBox.getChildren().add(b);

        vBox.setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>() {    // Evenimentul pentru apasarea pe ( Vbox )
            @Override
            public void handle(MouseEvent event) {
                System.out.println("vbox handler");
            }
        });

        Scene scene = new Scene(vBox, 300, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
