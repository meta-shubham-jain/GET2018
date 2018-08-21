import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

/**
 * This class is for Connection with database
 * 
 * @author Shubham Jain
 *
 */
public class ConnectionToDatabase {

    /**
     * It will connect to database and returns Connection Object
     * 
     * @return Connection Object
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(UtilityForConnection.getConnectionClass());
            String database = UtilityForConnection.getDataBaseName();
            String userName = UtilityForConnection.getUserName();
            String password = UtilityForConnection.getPassword();
            String url = UtilityForConnection.getUrl() + database;
            conn = (Connection) DriverManager.getConnection(url, userName,
                    password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(2);
        }
        return conn;
    }
}