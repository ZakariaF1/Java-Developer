package Java_Gui3_JDBC;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://163.172.160.14:3306/javafx_booking?user=root&password=java123";     // Cream un ( url ) care o sa fie folosita pentru conectiune
        Connection connection = DriverManager.getConnection(url);               // Facem conectiunea cu ( url )
        Statement statement = connection.createStatement();                     // Cream un statement
        //statement.executeUpdate("UPDATE users SET username='test' WHERE username='java' ");               // Pentru a actualiza baza de date
        //ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS nr FROM users");           // Cream un ResultSet ca rezultat al ( executeQuery() )
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        while (resultSet.next()) {                      // Ne da ( True ) cand linia urmatoare exista
            //String id = resultSet.getString("nr");
            //String id = resultSet.getString(5);       // Ne da valorile ale unei coloane folosind( columnIndex )
            //String id = resultSet.getString("password");
            int id = resultSet.getInt("password1");
            System.out.println(id);
        }
    }
}