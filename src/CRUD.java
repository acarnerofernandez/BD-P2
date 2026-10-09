import java.sql.*;

public class CRUD {


    public void meterAnime(String nombre, String descripcion, Date fecha, int puntuacion) {
        String sql = "INSERT INTO anime (nome, descripcion, data, puntuacion) VALUES (?, ?, ?, ?)";

        try (Connection conn = BD_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, descripcion);
            pstmt.setDate(3, fecha);
            pstmt.setInt(4, puntuacion);

            pstmt.executeUpdate();
            System.out.println("Anime '" + nombre + "' insertado con éxito.");

        } catch (SQLException e) {
            System.err.println("Error al insertar el anime: " + e.getMessage());
        }
    }


    public void leerDatos() {
        String sql = "SELECT * FROM anime";

        try (Connection conn = BD_Connection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nome");
                String descripcion = rs.getString("descripcion");
                Date fechaSql = rs.getDate("data");
                int puntuacion = rs.getInt("puntuacion");

                String fechaFormateada = Data.dateToString(fechaSql);

                System.out.println("Nombre: " + nombre +
                        " | Estreno: " + fechaFormateada +
                        " | Puntuación: " + puntuacion +
                        "\n   Descripción: " + descripcion);

            }

        } catch (SQLException e) {
            System.err.println("Error al leer los datos: " + e.getMessage());
        }
    }


    public void actualizarAnime(String nombre, String nuevaDescripcion, Date nuevaFecha, int nuevaPuntuacion) {
        String sql = "UPDATE anime SET descripcion = ?, data = ?, puntuacion = ? WHERE nome = ?";

        try (Connection conn = BD_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevaDescripcion);
            pstmt.setDate(2, nuevaFecha);
            pstmt.setInt(3, nuevaPuntuacion);
            pstmt.setString(4, nombre);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Anime '" + nombre + "' actualizado con éxito.");
            } else {
                System.out.println("No se encontró ningún anime con el nombre: " + nombre);
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar el anime: " + e.getMessage());
        }
    }


    public void eliminarAnime(String nombre) {
        String sql = "DELETE FROM anime WHERE nome = ?";

        try (Connection conn = BD_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Anime '" + nombre + "' eliminado con éxito.");
            } else {
                System.out.println("No se encontró ningún anime con el nombre: " + nombre);
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar el anime: " + e.getMessage());
        }
    }
}