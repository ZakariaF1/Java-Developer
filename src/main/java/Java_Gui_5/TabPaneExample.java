package Java_Gui_5;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TabPaneExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tabs");
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 400, 250, Color.WHITE);

        TabPane tabPane = new TabPane();       // Cream un ( TabPane ) pentru ( Tab-uri (


        for (int i = 0; i < 5; i++) {

            HBox hbox = new HBox();
            hbox.getChildren().add(new Label("Tab" + i));
            hbox.setAlignment(Pos.CENTER);                  // Pentru a positiona ( Hbox-ul ) in centru

            Tab tab = new Tab();                 // Cream un ( Tab )
            tab.setText("Tab " + i);
            tab.setContent(hbox);                // Punem ( Hbox ) in ( Tab-uri )

            tabPane.getTabs().add(tab);
        }
        //largeste borderpane-ul pe toate suprafata
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setCenter(tabPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
