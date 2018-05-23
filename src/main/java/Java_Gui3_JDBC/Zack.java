package Java_Gui3_JDBC;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Zack extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        final TextField userTextField = new TextField();
        final TextField passwordTextField = new TextField();
        Label label1 = new Label("Username");
        Label label2 = new Label("Password");
        final Label check = new Label();

        Button button1 = new Button("Submit");

        button1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String usernameEntered = userTextField.getText();
                String passwordEntered = passwordTextField.getText();
                String url = "jdbc:mysql://163.172.160.14:3306/javafx_booking?user=root&password=java123";     // Cream un ( url ) care o sa fie folosita pentru conectiune
                try{
                Connection connection = DriverManager.getConnection(url);               // Facem conectiunea cu ( url )
                Statement statement = connection.createStatement();                     // Cream un statement
                //statement.executeUpdate("UPDATE users SET username='test' WHERE username='java' ");               // Pentru a actualiza baza de date
                //ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS nr FROM users");           // Cream un ResultSet ca rezultat al ( executeQuery() )
                String sqlVerify = "SELECT COUNT(*) AS nr FROM users WHERE username= '" + usernameEntered + "' and password= '" + passwordEntered + "';";
                ResultSet resultSet = statement.executeQuery(sqlVerify);
                resultSet.next();
                int nr = resultSet.getInt("nr");
                if (nr == 1) {
                    check.setText("SUCCESS !!");
                }
                else {
                    check.setText("FAIL !!");
                }

                } catch (Exception e) {

                }
            }
        });
         GridPane gridPane = new GridPane();

         gridPane.setHgap(10);
         gridPane.setVgap(10);

        gridPane.setConstraints(label1, 0, 0);
        gridPane.setConstraints(label2, 0, 1);
        gridPane.setConstraints(userTextField, 1, 0);
        gridPane.setConstraints(passwordTextField, 1, 1);
        gridPane.setConstraints(button1, 0, 3);
        gridPane.setConstraints(check, 0, 4);


        gridPane.getChildren().addAll(userTextField, passwordTextField, label1, label2, button1, check);


        Scene scene1 = new Scene(gridPane, Screen.getPrimary().getBounds().getWidth(),Screen.getPrimary().getBounds().getHeight());

        primaryStage.setScene(scene1);
        primaryStage.show();
        primaryStage.setTitle("Hello");

    }
}
