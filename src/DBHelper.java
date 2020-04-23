import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private String userName = "root";
    private String password = "";
    private String dbUrl = "jdbc:mysql://localhost:3306/world";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, userName, password);
    }

    public void showErrorMessage (SQLException sqlException) {
        System.out.println("Error : " + sqlException.getMessage());
        System.out.println("Error code : " + sqlException.getErrorCode());
    }
}
