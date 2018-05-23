package Java_Gui_4;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {

        LoginPage loginPage = new LoginPage();

        loginPage.buildScene(primaryStage);

        primaryStage.show();
    }
}
