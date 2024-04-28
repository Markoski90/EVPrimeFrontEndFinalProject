package utils;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class DbClient {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/evprime";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static void deleteEventById(int eventId) {

        String deleteQuery = "DELETE FROM events WHERE id = '" + eventId + "'";

        try (
                Connection connection = getConnection(DB_URL, USERNAME, PASSWORD);

                Statement statement = connection.createStatement()
        ) {

            statement.executeUpdate(deleteQuery);

            System.out.println("Event deleted successfully from the database!");
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }

}


