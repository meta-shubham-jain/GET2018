/**
 * This Class is utility class which provides database connection parameters
 * @author Shubham Jain
 *
 */
public class UtilityForConnection {
    private static final String databaseName = "store_front";
    private static final String userName = "root";
    private static final String password = "1234";
    private static final String connectionClass = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/";
    
    /**
     * Returns database name
     * @return
     */
    public static String getDataBaseName() {
        return databaseName;
    } 
    
    /**
     * Returns user name
     * @return
     */
    public static String getUserName() {
        return userName;
    }
    
    /**
     * Returns password
     * @return
     */
    public static String getPassword() {
        return password;
    }
    
    /**
     * Returns Connection class path
     * @return
     */
    public static String getConnectionClass() {
        return connectionClass;
    }
    
    /**
     * Returns URL for JDBC Connection
     * @return
     */
    public static String getUrl() {
        return url;
    }
}