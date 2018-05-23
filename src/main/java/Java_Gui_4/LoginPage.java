package Java_Gui_4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.sql.*;

public class LoginPage {

    public void buildScene(final Stage stage) {               // Metoda care creaza o scena specifica al clasei

        final TextField usernameField = new TextField();
        final TextField passwordField = new TextField();
        final Button loginButton = new Button("Login");
        final Label loginResult = new Label();

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String enteredUsername = usernameField.getText();
                String enteredPass = passwordField.getText();

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://163.172.160.14:3306/javafx_booking?user=root&password=java123");

                    PreparedStatement statement = con.prepareStatement("select * from users where username=?;");    // Prepare Statement e pentru folosirea ( ? )
                    statement.setString(1, enteredUsername);    // Pentru setarea Statementului ( 1 inseamna primul semn de intrebare si dupaia valoarea sa

                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        String correctPassword = resultSet.getString("password");
                        if (correctPassword.equals(enteredPass)) {
                            loginResult.setTextFill(Color.BLACK);
                            loginResult.setText("SUCCESS!!");
                            ListingPage listingPage = new ListingPage();
                            listingPage.buildScene(stage);          // Activam scena ( Listing page )
                            return;
                        }
                    }
                    loginResult.setTextFill(Color.RED);
                    loginResult.setText("User sau parola gresite!");

                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(15, 15, 15, 15));
        vBox.getChildren().addAll(usernameField, passwordField, loginButton, loginResult);

        Scene scene1 = new Scene(vBox, Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());    // Pentru a face scena complet pe ecran
        stage.setScene(scene1);
    }
}
