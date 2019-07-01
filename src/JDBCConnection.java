import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getJDBCConnection() {
        final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        final String user = "cuong";
        final String password = "123456";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            try {
                return DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
