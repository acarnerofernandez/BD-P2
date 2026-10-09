import java.sql.*;

public class BD_Connection {

    public static Connection getConnection() {

        String url = "jdbc:postgresql://10.0.9.127:5432/postgres";
        String usuario = "postgres";
        String contrasena = "admin";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, usuario, contrasena);
            if (conn != null) {
                System.out.println("Conexión establecida con éxito a PostgreSQL.");
            }
        } catch (SQLException error) {
            System.out.println("Error: " + error.getMessage());
        }

        return conn;
    }
}