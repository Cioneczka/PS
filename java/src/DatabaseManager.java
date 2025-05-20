import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/orcl1"; // Zmień na właściwy SID lub service_name
    private static final String USER = "SYS as SYSDBA ";
    private static final String PASSWORD = "root";

    public static void saveCalculation(String equation, String operation, double result) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO calculations (equation, operation, result) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, equation);
                stmt.setString(2, operation);
                stmt.setDouble(3, result);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
