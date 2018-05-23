package Java_Gui_4;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.InputStream;
import java.sql.*;

public class ListingPage {


    public void buildScene(final Stage stage) throws SQLException {         // Metoda care creaza o scena specifica al clasei
        FlowPane flowPane = new FlowPane();                           // Cream un Flow Pane horizontal care muta copii in cazul scaderea width-ului ferestrei
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.setPadding(new Insets(10, 10, 10, 10));

        Connection connection = DriverManager.getConnection("jdbc:mysql://163.172.160.14:3306/javafx_booking?user=root&password=java123");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from rooms");
        ResultSet resultset = preparedStatement.executeQuery();
        while (resultset.next() ) {          // Cream o bucla pentru a crea un ( Vbox ) nou pana nu mai sunt randuri in baza de date MySql
            String title = resultset.getString("title");     // Cream un String care se numeste ( title ) si are valoarea coloanei din baza de date
            Integer id = resultset.getInt("id");

            VBox room = new VBox();
            room.setId(id + "");         // Pentru a adauga ( id-ul ) din baza de date a camerei in MySql si in( vbox )
            room.setPrefWidth(300);      // Pentru setarea ( Width-ul vbox-ului )
            room.setBorder(new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));     // Pentru setarea Vbox-ului
            Label titleLabel = new Label(title);                   // Cream un label in ( Vbox ) si punem valoarea din baza de date
            titleLabel.setFont(new Font("Arial", 18));       // Setam textul ( label-ului )
            titleLabel.setTextFill(Color.RED);
            //room.getChildren().add(titleLabel);

            Image image = null;
            try {
                InputStream s = ListingPage.class.getResourceAsStream("room.jpg");     // Punem poza din ( resources ) in InputStream
                image = new Image(s);
            } catch (Exception e) {
                e.printStackTrace();
            }

            ImageView imageView = new ImageView(image);
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(300);
            imageView.setSmooth(true);
            //room.getChildren().add(imageView);

            Label description = new Label(resultset.getString("description"));
            description.setWrapText(true);                // Pentru a trece textul la urmatoarea linie daca nu incape
            description.setFont(Font.font("Delicious"));
            //room.getChildren().add(description);

            Label price = new Label();
            price.setText(resultset.getString("price"));      // Setam ( Price ) cu valoarea din baza de date
            room.getChildren().addAll(titleLabel, description, price, imageView);

            flowPane.getChildren().add(room);

            room.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    String id = ((VBox)event.getSource()).getId();             // Adaugam ( Id-ul ) din baza de date la ( String id )
                    ReservationPage reservationPage = new ReservationPage(id);
                    reservationPage.buildScene(stage);
                }
            });
        }

        Scene scene = new Scene(flowPane, Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());
        stage.setScene(scene);
    }

}
