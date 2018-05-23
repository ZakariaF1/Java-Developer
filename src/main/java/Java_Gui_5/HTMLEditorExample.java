package Java_Gui_5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.stream.Collectors;

public class HTMLEditorExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        VBox vBox = new VBox();

        HTMLEditor htmlEditor = new HTMLEditor();              // Creaza un Editor de ( Text )

        Button button = new Button("Save");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("index.html"));
                    writer.write(htmlEditor.getHtmlText());
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        vBox.getChildren().addAll(htmlEditor, button);

        Scene scene = new Scene(vBox, 300, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
