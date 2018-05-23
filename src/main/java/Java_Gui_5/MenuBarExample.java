package Java_Gui_5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuBarExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox();

        MenuBar menuBar = new MenuBar();              // Cream un ( MenuBar ) principal

        Menu fileMenu = new Menu(("File"));           // Cream un ( Menu ) pentru ( MenuBar-ul ) principal
        MenuItem open = new MenuItem("Open");    // Cream un ( MenuItem ) pentru ( Menu ) care este in ( MenuBar-ul ) principal
        open.setOnAction(new EventHandler<ActionEvent>() {             // Cream un eveniment pentru ( MenuItem )
            @Override
            public void handle(ActionEvent event) {
                System.out.println("da");
            }
        });

        fileMenu.getItems().add(open);               // Adaugam ( MenuItem ) in ( Menu )
        menuBar.getMenus().add(fileMenu);            // Adaugam ( Menu ) in ( MenuBar )
        menuBar.getMenus().add(new Menu("Help"));
        menuBar.getMenus().add(new Menu("About"));

        vBox.getChildren().add(menuBar);

        Scene scene = new Scene(vBox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
