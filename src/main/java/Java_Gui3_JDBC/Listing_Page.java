package Java_Gui3_JDBC;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class Listing_Page {

    public Scene buildScene() {

        FlowPane flowPane1 = new FlowPane();

        VBox vBox1 = new VBox();

        Label roomTitle = new Label();
        Label roomDesc = new Label();

        vBox1.getChildren().addAll(roomDesc, roomTitle);

        Scene scene1 = new Scene(flowPane1, Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());

        return scene1;
    }
}
