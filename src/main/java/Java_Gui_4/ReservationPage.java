package Java_Gui_4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;

public class ReservationPage {

    private String roomId;

    public ReservationPage(String roomId) {
        this.roomId = roomId;
    }

    public void buildScene(final Stage stage) {               // Metoda care creaza o scena specifica al clasei
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10, 10, 10,10));

        HBox datePicker1Hbox = new HBox();
        final DatePicker datePickerStart = new DatePicker();                   // Cream ( DatePicker )
        datePicker1Hbox.getChildren().addAll(new Label("Data inceput: "), datePickerStart);

        HBox datePicker2Hbox = new HBox();
        final DatePicker datePickerEnd = new DatePicker();
        datePicker2Hbox.getChildren().addAll(new Label("Data final: "), datePickerEnd);


        Button buttonReserve = new Button("Rezerva");
        buttonReserve.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                //Validam perioada selectata de utilizator

                LocalDate start = datePickerStart.getValue();
                LocalDate end = datePickerEnd.getValue();


                try {
                    Connection connection =  DriverManager.getConnection("jdbc:mysql://163.172.160.14:3306/javafx_booking?user=root&password=java123");
                    PreparedStatement ps = connection.prepareStatement("insert into reservations values (null, ?, ?, ?)");   // Am folosit ( PrepareStatement ) pentru ca adaugam Wild Cards ( ? )
                    ps.setInt(1, Integer.valueOf(roomId));           // Pentru a pune valori in ( ? )
                    ps.setDate(2, Date.valueOf(start));
                    ps.setDate(3, Date.valueOf(end));

                    ps.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

        vBox.getChildren().addAll(datePicker1Hbox, datePicker2Hbox, buttonReserve);

        Scene scene = new Scene(vBox, 500, 500);
        stage.setScene(scene);
    }
}
