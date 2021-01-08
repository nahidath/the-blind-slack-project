package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    /**
     *
     * @return
     */
    public static Connection getConnectionToDatabase() {
        Connection connection = null;

        try {

            // load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("MySQL JDBC Driver Registered!");

            // get hold of the DriverManager
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/slack", "root", "root");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();

        }

        catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (connection != null) {
            System.out.println("Connection made to DB!");
        }
        return connection;
    }

}
