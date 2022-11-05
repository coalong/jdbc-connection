import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {

    private DbUtils() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db01",
                "root",
                "960819");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
